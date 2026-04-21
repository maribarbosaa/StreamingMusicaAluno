import java.util.ArrayList;

public class UsuarioPremium extends Usuario {

    private String plano;
    private ArrayList<Musica> musicasBaixadas;

    public UsuarioPremium(String nome, String email, String plano) {
        super(nome, email);
        this.plano = plano;
        this.musicasBaixadas = new ArrayList<>();
    }

    @Override
    public void reproduzirMusica(Musica musica) {
        System.out.println("ALTA QUALIDADE: " + musica.getTitulo());
        historicoReproducao.add(musica);
    }

    public void baixarMusica(Musica musica) {
        if (!musicasBaixadas.contains(musica)) {
            musicasBaixadas.add(musica);
            System.out.println("⬇Música baixada!");
        } else {
            System.out.println("Já está baixada!");
        }
    }

    public void listarMusicasBaixadas() {
        System.out.println("\n--- DOWNLOADS ---");

        if (musicasBaixadas.isEmpty()) {
            System.out.println("Nenhuma música.");
            return;
        }

        for (Musica m : musicasBaixadas) {
            m.exibir();
        }
    }
}