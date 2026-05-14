package br.com.streaming.modelo;

import br.com.streaming.servico.Reproduzivel;
import java.util.ArrayList;

public class Playlist implements Reproduzivel {

    protected String nome;
    protected ArrayList<Musica> musicas;
    protected String descricao;
    protected boolean pausada;
    protected boolean tocando;

    public Playlist(String nome) {
        this.nome = nome;
        this.musicas = new ArrayList<>();
        this.pausada = false;
        this.tocando = false;
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    // ========== Implementação da interface Reproduzivel ==========

    @Override
    public void reproduzir() {
        tocando = true;
        pausada = false;
        System.out.println("Reproduzindo playlist: " + nome);
        for (Musica m : musicas) {
            System.out.println("   " + m.getTitulo());
        }
    }

    @Override
    public void pausar() {
        if (tocando) {
            pausada = true;
            tocando = false;
            System.out.println("Playlist pausada: " + nome);
        }
    }

    @Override
    public void parar() {
        tocando = false;
        pausada = false;
        System.out.println("Playlist parada: " + nome);
    }

    @Override
    public int getDuracaoTotal() {
        int total = 0;
        for (Musica m : musicas) {
            total += m.getDuracaoTotal();
        }
        return total;
    }

    // ========== Getters ==========

    public String getNome() {
        return nome;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public int getQuantidadeMusicas() {
        return musicas.size();
    }
}