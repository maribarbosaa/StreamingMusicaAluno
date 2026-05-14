import br.com.streaming.modelo.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StreamingMusica {

    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static ArrayList<Musica> musicas = new ArrayList<>();
    static Usuario usuarioLogado = null;
    public static int anunciosExibidos = 0;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Usuários iniciais
        usuarios.add(new UsuarioFree("Mariana", "mariana@email.com"));
        usuarios.add(new UsuarioPremium("Rosângela", "rosangela@email.com", "Premium"));
        usuarios.add(new UsuarioFree("Milly", "milly@email.com"));

        // Músicas 
        musicas.add(new Musica("Pra Não Pensar em Você", "Zezé de Camargo e Luciano", 200));
        musicas.add(new Musica("Blinding Lights", "The Weeknd", 210));
        musicas.add(new Musica("I Miss the Misery", "Halsey", 190));
        musicas.add(new Musica("In Your Eyes", "The Weeknd", 280));
        musicas.add(new Musica("Eu vim de Santos", "Charlie Brown Jr.", 300));
        musicas.add(new Musica("Garota de Ipanema", "Tom Jobim", 180));
        musicas.add(new Musica("Shape of You", "Ed Sheeran", 240));
        musicas.add(new Musica("Bohemian Rhapsody", "Queen", 360));
        musicas.add(new Musica("Smells Like Teen Spirit", "Nirvana", 300));
        musicas.add(new Musica("Billie Jean", "Michael Jackson", 290));
        musicas.add(new Musica("Rolling in the Deep", "Adele", 220));
        musicas.add(new Musica("Hotel California", "Eagles", 390));     
        musicas.add(new Musica("Hey Jude", "The Beatles", 430));
        musicas.add(new Musica("Lose Yourself", "Eminem", 320));    
        musicas.add(new Musica("Wonderwall", "Oasis", 250));        
        musicas.add(new Musica("Hallelujah", "Leonard Cohen", 360));
        musicas.add(new Musica("Stairway to Heaven", "Led Zeppelin",    480));
        musicas.add(new Musica("Like a Rolling Stone", "Bob Dylan", 370 ));
        musicas.add(new Musica("Imagine", "John Lennon", 180));    
        musicas.add(new Musica("Céu Azul", "Charlie Brown Jr", 300));      

        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE STREAMING ===");
            System.out.println("1. Criar novo usuário");
            System.out.println("2. Login");
            System.out.println("3. Listar usuários");
            System.out.println("4. Playlists automáticas");
            System.out.println("5. Reproduzir música");
            System.out.println("6. Downloads (Premium)");
            System.out.println("7. Estatísticas");
            System.out.println("0. Sair");

            System.out.print("\nEscolha: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1: criarUsuario(); break;
                case 2: login(); break;
                case 3: listarUsuarios(); break;
                case 4: menuPlaylists(); break;
                case 5: menuReproduzir(); break;
                case 6: menuDownloads(); break;
                case 7: exibirEstatisticas(); break;
            }

        } while (opcao != 0);

        System.out.println("\nAté logo!");
        scanner.close();
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
            System.out.println("Usuário Free criado!");
        } else {
            System.out.print("Plano (Mensal/Anual/Familiar): ");
            String plano = scanner.nextLine();
            usuarios.add(new UsuarioPremium(nome, email, plano));
            System.out.println("Usuário Premium criado!");
        }
    }

    public static void login() {
        listarUsuarios();
        System.out.print("\nEscolha o número do usuário: ");
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
            String tipo = (u instanceof UsuarioPremium) ? "Premium" : "Free";
            System.out.println(i + ". " + u.getNome() + " (" + tipo + ")");
            i++;
        }
    }

    // ================= REPRODUÇÃO =================

    public static void menuReproduzir() {
        if (usuarioLogado == null) {
            System.out.println("Faça login primeiro!");
            return;
        }

        System.out.println("\nMúsicas disponíveis:");
        for (int i = 0; i < musicas.size(); i++) {
            System.out.println((i + 1) + ". " + musicas.get(i).getTitulo()
                    + " - " + musicas.get(i).getArtista());
        }

        System.out.print("Escolha uma música: ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        usuarioLogado.reproduzirMusica(musicas.get(idx));
    }

    // ================= DOWNLOADS =================

    public static void menuDownloads() {
        if (usuarioLogado == null) {
            System.out.println("Faça login primeiro!");
            return;
        }

        if (!(usuarioLogado instanceof UsuarioPremium)) {
            System.out.println(" Downloads disponíveis apenas para usuários Premium!");
            return;
        }

        UsuarioPremium premium = (UsuarioPremium) usuarioLogado;

        System.out.println("\n=== DOWNLOADS ===");
        System.out.println("1. Baixar música");
        System.out.println("2. Remover download");
        System.out.println("3. Ver músicas baixadas");

        System.out.print("Escolha: ");
        int opcao = Integer.parseInt(scanner.nextLine());

        if (opcao == 1) {
            System.out.println("\nMúsicas disponíveis:");
            for (int i = 0; i < musicas.size(); i++) {
                System.out.println((i + 1) + ". " + musicas.get(i).getTitulo());
            }
            System.out.print("Escolha: ");
            int idx = Integer.parseInt(scanner.nextLine()) - 1;
            premium.baixar(musicas.get(idx));

        } else if (opcao == 2) {
            ArrayList<Musica> baixadas = premium.getMusicasBaixadas();
            if (baixadas.isEmpty()) {
                System.out.println("Nenhuma música baixada.");
                return;
            }
            for (int i = 0; i < baixadas.size(); i++) {
                System.out.println((i + 1) + ". " + baixadas.get(i).getTitulo());
            }
            System.out.print("Remover qual? ");
            int idx = Integer.parseInt(scanner.nextLine()) - 1;
            premium.removerDownload(baixadas.get(idx));

        } else if (opcao == 3) {
            ArrayList<Musica> baixadas = premium.getMusicasBaixadas();
            if (baixadas.isEmpty()) {
                System.out.println("Nenhuma música baixada.");
            } else {
                System.out.println("Músicas baixadas (" + premium.getTamanhoBaixados() + "):");
                for (Musica m : baixadas) {
                    System.out.println("  - " + m.getTitulo());
                }
            }
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
            case 1: playlist = new PlaylistAutomatica("Top 10 Mais Tocadas", "top"); break;
            case 2: playlist = new PlaylistAutomatica("Recomendadas", "recomendadas"); break;
            case 3: playlist = new PlaylistAutomatica("Recentes", "recentes"); break;
        }

        if (playlist != null) {
            playlist.atualizar(musicas);
            for (int i = 0; i < 10; i++) {
                playlist.adicionarMusica(musicas.get(i % musicas.size()));
            }
            System.out.println("Playlist \"" + playlist.getNome() + "\" gerada com "
                    + playlist.getQuantidadeMusicas() + " músicas!");
            playlist.reproduzir();
        }
    }

    // ================= ESTATÍSTICAS =================

    public static void exibirEstatisticas() {
        int free = 0, premium = 0;
        int playsFree = 0, playsPremium = 0;

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
        System.out.println("  Free: " + free + " usuários");
        System.out.println("  Premium: " + premium + " usuários");
        System.out.println("\nReproduções totais: " + totalPlays);

        if (totalPlays > 0) {
            System.out.println("  Free: " + playsFree + " (" + (playsFree * 100 / totalPlays) + "%)");
            System.out.println("  Premium: " + playsPremium + " (" + (playsPremium * 100 / totalPlays) + "%)");
        }

        System.out.println("\nAnúncios exibidos: " + anunciosExibidos);
    }
}