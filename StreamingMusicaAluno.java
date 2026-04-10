import java.util.ArrayList;
import java.util.Scanner;

public class StreamingMusicaAluno {

    static ArrayList<Musica> catalogo = new ArrayList<>();
    static Usuario usuario = new Usuario("Usuário");

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        adicionarMusicasTeste();

        int opcao;

        do {
            exibirMenu();
            opcao = Integer.parseInt(scanner.nextLine());

            try {
                switch (opcao) {
                    case 1: cadastrarMusica(); break;
                    case 2: listarMusicas(); break;
                    case 3: menuBusca(); break;
                    case 4: criarPlaylist(); break;
                    case 5: gerenciarPlaylists(); break;
                    case 6: exibirEstatisticas(); break;
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);
    }

    static void exibirMenu() {
        System.out.println("\n1. Cadastrar música\n2. Listar\n3. Buscar\n4. Criar playlist\n5. Gerenciar\n6. Estatísticas\n0. Sair");
    }

    static void cadastrarMusica() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Artista: ");
        String artista = scanner.nextLine();

        System.out.print("Duração: ");
        int duracao = Integer.parseInt(scanner.nextLine());

        System.out.print("Gênero: ");
        String genero = scanner.nextLine();

        Musica m = new Musica(titulo, artista, duracao, genero);
        catalogo.add(m);

        System.out.println("Cadastrado!");
    }

    static void listarMusicas() {
        for (int i = 0; i < catalogo.size(); i++) {
            System.out.print((i + 1) + ". ");
            catalogo.get(i).exibir();
        }
    }

    static void menuBusca() {
        System.out.print("Buscar: ");
        String busca = scanner.nextLine();

        for (Musica m : catalogo) {
            if (m.contemTitulo(busca) || m.contemArtista(busca)) {
                m.exibir();
            }
        }
    }

    static void criarPlaylist() {
        System.out.print("Nome: ");
        usuario.criarPlaylist(scanner.nextLine());
    }

    static void gerenciarPlaylists() {
        usuario.listarPlaylists();
    }

    static void exibirEstatisticas() {
        int total = catalogo.size();
        int duracao = 0;

        for (Musica m : catalogo) {
            duracao += m.getDuracaoSegundos();
        }

        System.out.println("Total: " + total);
        System.out.println("Duração total: " + duracao);
    }

    static void adicionarMusicasTeste() {
        catalogo.add(new Musica("Bohemian Rhapsody", "Queen", 354, "Rock"));
        catalogo.add(new Musica("Billie Jean", "Michael Jackson", 293, "Pop"));
    }
}