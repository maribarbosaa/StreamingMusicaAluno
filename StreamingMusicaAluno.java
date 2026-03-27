import java.util.ArrayList;
import java.util.Scanner;

public class StreamingMusicaAluno {

    static ArrayList<Musica> catalogo = new ArrayList<>();
    static Usuario usuario = new Usuario();

    static final String[] GENEROS_VALIDOS = {"Pop", "Rock", "Jazz", "Eletrônica", "Hip-Hop", "Clássica"};

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        usuario.nome = "Usuário";
        adicionarMusicasTeste();

        int opcao;

        do {
            exibirMenu();
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarMusica();
                    break;
                case 2:
                    listarMusicas();
                    break;
                case 3:
                    menuBusca();
                    break;
                case 4:
                    criarPlaylist();
                    break;
                case 5:
                    gerenciarPlaylists();
                    break;
                case 6:
                    exibirEstatisticas();
                    break;
            }

        } while (opcao != 0);

        System.out.println("Sistema encerrado.");
    }

    static void exibirMenu() {
        System.out.println("\n=== SISTEMA DE STREAMING DE MÚSICA ===");
        System.out.println("1. Cadastrar música");
        System.out.println("2. Listar todas as músicas");
        System.out.println("3. Buscar música");
        System.out.println("4. Criar playlist");
        System.out.println("5. Gerenciar playlists");
        System.out.println("6. Exibir estatísticas");
        System.out.println("0. Sair");
    }

    // ================= CADASTRAR =================

    static void cadastrarMusica() {

        Musica m = new Musica();

        System.out.print("Título: ");
        m.titulo = scanner.nextLine();

        System.out.print("Artista: ");
        m.artista = scanner.nextLine();

        System.out.print("Duração (segundos): ");
        m.duracaoSegundos = Integer.parseInt(scanner.nextLine());

        System.out.println("Escolha o gênero:");
        for (int i = 0; i < GENEROS_VALIDOS.length; i++) {
            System.out.println((i + 1) + ". " + GENEROS_VALIDOS[i]);
        }

        int g = Integer.parseInt(scanner.nextLine());
        m.genero = GENEROS_VALIDOS[g - 1];

        catalogo.add(m);

        System.out.println("Música cadastrada com sucesso!");
    }

    // ================= LISTAR =================

    static void listarMusicas() {

        if (catalogo.isEmpty()) {
            System.out.println("Nenhuma música cadastrada.");
            return;
        }

        for (int i = 0; i < catalogo.size(); i++) {
            System.out.print((i + 1) + ". ");
            catalogo.get(i).exibir();
        }
    }

    // ================= BUSCAR =================

    static void menuBusca() {

        int op;

        do {
            System.out.println("\n=== BUSCAR MÚSICA ===");
            System.out.println("1. Buscar por título");
            System.out.println("2. Buscar por artista");
            System.out.println("0. Voltar");

            op = Integer.parseInt(scanner.nextLine());

            switch (op) {
                case 1:
                    buscarPorTitulo();
                    break;
                case 2:
                    buscarPorArtista();
                    break;
            }

        } while (op != 0);
    }

    static void buscarPorTitulo() {
        System.out.print("Digite o título: ");
        String busca = scanner.nextLine();

        boolean encontrou = false;

        for (Musica m : catalogo) {
            if (m.contemTitulo(busca)) {
                m.exibir();
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma música encontrada.");
        }
    }

    static void buscarPorArtista() {
        System.out.print("Digite o artista: ");
        String busca = scanner.nextLine();

        boolean encontrou = false;

        for (Musica m : catalogo) {
            if (m.contemArtista(busca)) {
                m.exibir();
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma música encontrada.");
        }
    }

    // ================= PLAYLIST =================

    static void criarPlaylist() {
        System.out.print("Nome da playlist: ");
        String nome = scanner.nextLine();
        usuario.criarPlaylist(nome);
    }

    static void gerenciarPlaylists() {

        int op;

        do {
            System.out.println("\n=== GERENCIAR PLAYLISTS ===");
            System.out.println("1. Listar minhas playlists");
            System.out.println("2. Adicionar música a uma playlist");
            System.out.println("3. Remover música de uma playlist");
            System.out.println("4. Exibir detalhes de uma playlist");
            System.out.println("0. Voltar");

            op = Integer.parseInt(scanner.nextLine());

            switch (op) {
                case 1:
                    usuario.listarPlaylists();
                    break;

                case 2:
                    usuario.listarPlaylists();
                    System.out.print("Escolha a playlist: ");
                    int p = Integer.parseInt(scanner.nextLine()) - 1;

                    Playlist playlist = usuario.getPlaylist(p);

                    if (playlist != null) {
                        listarMusicas();
                        System.out.print("Escolha a música: ");
                        int m = Integer.parseInt(scanner.nextLine()) - 1;
                        playlist.adicionarMusica(catalogo.get(m));
                    }
                    break;

                case 3:
                    usuario.listarPlaylists();
                    System.out.print("Escolha a playlist: ");
                    int pr = Integer.parseInt(scanner.nextLine()) - 1;

                    Playlist pl = usuario.getPlaylist(pr);

                    if (pl != null) {
                        pl.listarMusicas();
                        System.out.print("Remover música: ");
                        int rm = Integer.parseInt(scanner.nextLine()) - 1;
                        pl.removerMusica(rm);
                    }
                    break;

                case 4:
                    usuario.listarPlaylists();
                    System.out.print("Escolha a playlist: ");
                    int pd = Integer.parseInt(scanner.nextLine()) - 1;

                    Playlist px = usuario.getPlaylist(pd);

                    if (px != null) {
                        System.out.println("Playlist: " + px.nome);
                        px.listarMusicas();
                        System.out.println("Total músicas: " + px.getQuantidadeMusicas());
                    }
                    break;
            }

        } while (op != 0);
    }

    // ================= ESTATÍSTICAS =================

    static void exibirEstatisticas() {

        if (catalogo.isEmpty()) {
            System.out.println("Nenhuma música cadastrada.");
            return;
        }

        int total = catalogo.size();
        int duracaoTotal = 0;

        for (Musica m : catalogo) {
            duracaoTotal += m.duracaoSegundos;
        }

        int media = duracaoTotal / total;

        System.out.println("Total de músicas: " + total);
        System.out.println("Duração total: " + formatarDuracao(duracaoTotal));
        System.out.println("Duração média: " + formatarDuracao(media));
    }

    static String formatarDuracao(int segundos) {
        int minutos = segundos / 60;
        int seg = segundos % 60;
        return String.format("%d:%02d", minutos, seg);
    }

    // ================= TESTE =================

    static void adicionarMusicasTeste() {

        Musica m1 = new Musica();
        m1.titulo = "Bohemian Rhapsody";
        m1.artista = "Queen";
        m1.duracaoSegundos = 354;
        m1.genero = "Rock";

        Musica m2 = new Musica();
        m2.titulo = "Billie Jean";
        m2.artista = "Michael Jackson";
        m2.duracaoSegundos = 293;
        m2.genero = "Pop";

        catalogo.add(m1);
        catalogo.add(m2);
    }
}