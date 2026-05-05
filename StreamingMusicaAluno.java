import java.util.ArrayList;
import java.util.Scanner;

public class StreamingMusicaAluno {

    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static ArrayList<Musica> musicas = new ArrayList<>();
    static Usuario usuarioLogado = null;
    static int anunciosExibidos = 0;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Usuários iniciais
        usuarios.add(new UsuarioFree("Mariana", "mariana@email.com"));
        usuarios.add(new UsuarioPremium("Rosângela", "rosangela@email.com", "Premium"));
        usuarios.add(new UsuarioFree("Milly", "milly@email.com"));

        // Músicas mock
        musicas.add(new Musica("Pra Não Pensar em Você"));
        musicas.add(new Musica("Blinding Lights"));
        musicas.add(new Musica("I Miss the Misery"));
        musicas.add(new Musica("In Your Eyes"));
        musicas.add(new Musica("Eu vim de Santos, sou Charlie Brown"));

        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE STREAMING ===");
            System.out.println("1. Criar novo usuário");
            System.out.println("2. Login");
            System.out.println("3. Listar usuários");
            System.out.println("4. Playlists automáticas");
            System.out.println("5. Estatísticas");
            System.out.println("0. Sair");

            System.out.print("\nEscolha: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    criarUsuario();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    listarUsuarios();
                    break;
                case 4:
                    menuPlaylists();
                    break;
                case 5:
                    exibirEstatisticas();
                    break;
            }

        } while (opcao != 0);
    }

    // ================= USUÁRIOS =================

    public static void criarUsuario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.println("\nTipo de conta:");
        System.out.println("1. Free");
        System.out.println("2. Premium");

        int tipo = Integer.parseInt(scanner.nextLine());

        if (tipo == 1) {
            usuarios.add(new UsuarioFree(nome, email));
        } else {
            System.out.print("Plano (Mensal/Anual/Familiar): ");
            String plano = scanner.nextLine();
            usuarios.add(new UsuarioPremium(nome, email, plano));
        }

        System.out.println("Usuário criado!");
    }

    public static void login() {
        listarUsuarios();

        System.out.print("\nEscolha o usuário: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        usuarioLogado = usuarios.get(index);

        if (usuarioLogado instanceof UsuarioPremium) {
            System.out.println("Login realizado: " + usuarioLogado.getNome() + " (Premium)");
        } else {
            System.out.println("Login realizado: " + usuarioLogado.getNome() + " (Free)");
        }
    }

    public static void listarUsuarios() {
        System.out.println("\nUsuários cadastrados:");

        int i = 1;
        for (Usuario u : usuarios) {

            if (u instanceof UsuarioPremium) {
                System.out.println(i + ". " + u.getNome() + " (Premium)");
            } else {
                System.out.println(i + ". " + u.getNome() + " (Free)");
            }
            i++;
        }
    }

    // ================= PLAYLISTS =================

    public static void menuPlaylists() {
        System.out.println("\n=== PLAYLISTS AUTOMÁTICAS ===");
        System.out.println("1. Top 10 Mais Tocadas");
        System.out.println("2. Recomendadas para Você");
        System.out.println("3. Adicionadas Recentemente");

        System.out.print("\nEscolha: ");
        int opcao = Integer.parseInt(scanner.nextLine());

        PlaylistAutomatica playlist = null;

        switch (opcao) {
            case 1:
                playlist = new PlaylistAutomatica("Top 10 Mais Tocadas", "top");
                break;
            case 2:
                playlist = new PlaylistAutomatica("Recomendadas", "recomendadas");
                break;
            case 3:
                playlist = new PlaylistAutomatica("Recentes", "recentes");
                break;
        }

        if (playlist != null) {
            System.out.println("Gerando playlist \"" + playlist.nome + "\"...");
            playlist.atualizar(musicas);

            // adiciona 10 músicas simuladas
            for (int i = 0; i < 10; i++) {
                playlist.adicionarMusica(musicas.get(i % musicas.size()));
            }

            System.out.println("Playlist criada com 10 músicas!");
        }
    }

    // ================= ESTATÍSTICAS =================

    public static void exibirEstatisticas() {

        int free = 0;
        int premium = 0;

        int playsFree = 0;
        int playsPremium = 0;

        for (Usuario u : usuarios) {

            if (u instanceof UsuarioPremium) {
                premium++;
                playsPremium += u.getReproducoes();
            } else {
                free++;
                playsFree += u.getReproducoes();
            }
        }

        int totalUsuarios = usuarios.size();
        int totalPlays = playsFree + playsPremium;

        System.out.println("\n=== ESTATÍSTICAS DO SISTEMA ===");
        System.out.println("Total de usuários: " + totalUsuarios);
        System.out.println("- Free: " + free + " usuários");
        System.out.println("- Premium: " + premium + " usuários");

        System.out.println("\nReproduções totais: " + totalPlays);

        if (totalPlays > 0) {
            System.out.println("- Free: " + playsFree + " reproduções (" + (playsFree * 100 / totalPlays) + "%)");
            System.out.println("- Premium: " + playsPremium + " reproduções (" + (playsPremium * 100 / totalPlays) + "%)");
        }

        System.out.println("\nAnúncios exibidos: " + anunciosExibidos);
    }
}