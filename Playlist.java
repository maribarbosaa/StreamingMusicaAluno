import java.util.ArrayList;

public class Playlist {
    private String nome;
    private ArrayList<Musica> musicas;

    public Playlist(String nome) {
        this.nome = nome;
        this.musicas = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
        System.out.println("🎶 Música adicionada à playlist!");
    }

    public void listarMusicas() {
        System.out.println("\n Playlist: " + nome);

        if (musicas.isEmpty()) {
            System.out.println("Nenhuma música.");
            return;
        }

        for (Musica m : musicas) {
            m.exibir();
        }
    }
}