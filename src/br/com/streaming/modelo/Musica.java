package br.com.streaming.modelo;

public class Musica extends ItemReproducao {

    private String artista;

    public Musica(String titulo) {
        super(titulo, 180);
        this.artista = "Desconhecido";
    }

    public Musica(String titulo, String artista, int duracaoSegundos) {
        super(titulo, duracaoSegundos);
        this.artista = artista;
    }

    @Override
    public void reproduzir() {
        tocando = true;
        pausada = false;
        System.out.println("Tocando: " + titulo + " - " + artista);
    }

    public String getArtista() {
        return artista;
    }
}