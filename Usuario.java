import java.util.ArrayList;

public class Usuario {
    protected String nome;
    protected String email;
    protected ArrayList<Playlist> playlists;
    protected ArrayList<Musica> historicoReproducao;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.playlists = new ArrayList<>();
        this.historicoReproducao = new ArrayList<>();
    }

    public void reproduzirMusica(Musica musica) {
        System.out.println("Reproduzindo: " + musica.getTitulo());
        historicoReproducao.add(musica);
    }

    public void exibirHistorico() {
        System.out.println("\n--- HISTÓRICO ---");
        for (Musica m : historicoReproducao) {
            m.exibir();
        }
    }

    public void criarPlaylist(String nome) {
        Playlist p = new Playlist(nome);
        playlists.add(p);
        System.out.println("Playlist criada!");
    }
}