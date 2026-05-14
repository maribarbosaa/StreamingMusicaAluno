package br.com.streaming.modelo;

public class PlaylistPersonalizada extends Playlist {

    private String criador;

    public PlaylistPersonalizada(String nome, String criador) {
        super(nome);
        this.criador = criador;
    }

    public PlaylistPersonalizada(String nome) {
        super(nome);
        this.criador = "Usuário";
    }

    @Override
    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
        System.out.println("🎶 \"" + musica.getTitulo() + "\" adicionada à playlist " + nome);
    }

    @Override
    public void reproduzir() {
        System.out.println("Playlist Personalizada de " + criador + ": " + nome);
        super.reproduzir();
    }

    public String getCriador() {
        return criador;
    }
}