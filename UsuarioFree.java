import java.util.ArrayList;

public class UsuarioFree extends Usuario {

    private int contadorReproducoes;
    private ArrayList<Playlist> playlists;

    public UsuarioFree(String nome, String email) {
        super(nome, email);
        this.contadorReproducoes = 0;
        this.playlists = new ArrayList<>();
    }

    @Override
    public void reproduzirMusica(Musica musica) {
        contadorReproducoes++;

        if (contadorReproducoes % 3 == 0) {
            exibirAnuncio();
        }

        super.reproduzirMusica(musica);
    }

    private void exibirAnuncio() {
        System.out.println("Anúncio sendo exibido...");
        StreamingMusicaAluno.anunciosExibidos++;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }
}