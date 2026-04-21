import java.util.Scanner;

public class StreamingMusicaAluno {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== BEM-VINDO AO STREAMING ===");

        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite seu email: ");
        String email = sc.nextLine();

        System.out.println("\nEscolha o tipo de conta:");
        System.out.println("1. Free");
        System.out.println("2. Premium");
        System.out.print("Escolha: ");
        int tipo = sc.nextInt();
        sc.nextLine();

        Usuario usuario;

        if (tipo == 1) {
            usuario = new UsuarioFree(nome, email);
            System.out.println("✅ Conta Free criada!");
        } else {

            System.out.println("\nEscolha o plano Premium:");
            System.out.println("1. Mensal");
            System.out.println("2. Anual");
            System.out.println("3. Familiar");
            System.out.print("Escolha: ");
            int plano = sc.nextInt();
            sc.nextLine();

            String tipoPlano;

            switch (plano) {
                case 1:
                    tipoPlano = "Mensal";
                    break;
                case 2:
                    tipoPlano = "Anual";
                    break;
                default:
                    tipoPlano = "Familiar";
                    break;
            }

            usuario = new UsuarioPremium(nome, email, tipoPlano);
            System.out.println("✅ Conta Premium criada!");
        }

        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Reproduzir música");
            System.out.println("2. Ver histórico");
            System.out.println("3. Criar playlist");

            if (usuario instanceof UsuarioPremium) {
                System.out.println("4. Baixar música");
                System.out.println("5. Ver músicas baixadas");
            }

            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Digite o nome da música: ");
                    String titulo = sc.nextLine();

                    Musica musica = new Musica(titulo, "Artista");
                    usuario.reproduzirMusica(musica);
                    break;

                case 2:
                    usuario.exibirHistorico();
                    break;

                case 3:
                    System.out.print("Nome da playlist: ");
                    String nomePlaylist = sc.nextLine();
                    usuario.criarPlaylist(nomePlaylist);
                    break;

                case 4:
                    if (usuario instanceof UsuarioPremium) {
                        UsuarioPremium up = (UsuarioPremium) usuario;

                        System.out.print("Música para baixar: ");
                        String tituloDownload = sc.nextLine();

                        Musica m = new Musica(tituloDownload, "Artista");
                        up.baixarMusica(m);
                    }
                    break;

                case 5:
                    if (usuario instanceof UsuarioPremium) {
                        UsuarioPremium up = (UsuarioPremium) usuario;
                        up.listarMusicasBaixadas();
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }
}