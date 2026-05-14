package br.com.streaming.modelo;

import br.com.streaming.servico.Baixavel;
import java.util.ArrayList;

public class UsuarioPremium extends Usuario implements Baixavel {

    private String plano;
    private ArrayList<Musica> musicasBaixadas;

    public UsuarioPremium(String nome, String email, String plano) {
        super(nome, email);
        this.plano = plano;
        this.musicasBaixadas = new ArrayList<>();
    }

    @Override
    public void reproduzirMusica(Musica musica) {
        System.out.println("Premium sem anúncios!");
        super.reproduzirMusica(musica);
    }

    // ========== Implementação da interface Baixavel ==========

    @Override
    public void baixar(Musica musica) {
        if (!estaBaixada(musica)) {
            musicasBaixadas.add(musica);
            System.out.println("Download concluído: " + musica.getTitulo());
        } else {
            System.out.println("⚠ \"" + musica.getTitulo() + "\" já está baixada.");
        }
    }

    @Override
    public void removerDownload(Musica musica) {
        if (musicasBaixadas.remove(musica)) {
            System.out.println("Download removido: " + musica.getTitulo());
        } else {
            System.out.println("⚠ \"" + musica.getTitulo() + "\" não estava baixada.");
        }
    }

    @Override
    public boolean estaBaixada(Musica musica) {
        return musicasBaixadas.contains(musica);
    }

    @Override
    public int getTamanhoBaixados() {
        return musicasBaixadas.size();
    }

    // ========== Getters ==========

    public String getPlano() {
        return plano;
    }

    public ArrayList<Musica> getMusicasBaixadas() {
        return musicasBaixadas;
    }
}