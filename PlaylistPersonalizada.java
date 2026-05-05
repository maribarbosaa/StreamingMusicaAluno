public class PlaylistPersonalizada extends Playlist {

    public PlaylistPersonalizada(String nome) {
        super(nome);
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
        System.out.println("🎶 Música adicionada!");
    }
}
