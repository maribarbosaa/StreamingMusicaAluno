import java.util.ArrayList;

public class PlaylistAutomatica extends Playlist {

    private String criterio;

    public PlaylistAutomatica(String nome, String criterio) {
        super(nome);
        this.criterio = criterio;
    }

    @Override
    public void reproduzir() {
        System.out.println(" Playlist Automática: " + nome);
        System.out.println(" Critério: " + criterio);
        super.reproduzir();
    }

    public void atualizar(ArrayList<Musica> todasMusicas) {
        musicas.clear();

        for (Musica m : todasMusicas) {
            if (criterio.equals("top")) {
                musicas.add(m);
            } else if (criterio.equals("recentes")) {
                musicas.add(m);
            }
        }
    }
}