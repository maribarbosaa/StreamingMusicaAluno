import java.util.ArrayList;

public class Playlist {
    protected String nome;
    protected ArrayList<Musica> musicas;
    protected String descricao;

    public Playlist(String nome) {
        this.nome = nome;
        this.musicas = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public void reproduzir() {
        System.out.println(" Reproduzindo playlist: " + nome);
        for (Musica m : musicas) {
            System.out.println("I>" + m.getTitulo());
        }
    }
}