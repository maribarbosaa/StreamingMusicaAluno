package br.com.streaming.modelo;

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
        System.out.println(" [Anúncio sendo exibido...]");
    }

    public ArrayList<Playlist> getPlaylists() {
         return playlists;
    }

    public void adicionarPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }
}