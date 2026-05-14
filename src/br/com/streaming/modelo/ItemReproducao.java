package br.com.streaming.modelo;

import br.com.streaming.servico.Reproduzivel;

public abstract class ItemReproducao implements Reproduzivel {

    protected String titulo;
    protected int duracaoSegundos;
    protected boolean tocando;
    protected boolean pausada;

    public ItemReproducao(String titulo, int duracaoSegundos) {
        this.titulo = titulo;
        this.duracaoSegundos = duracaoSegundos;
        this.tocando = false;
        this.pausada = false;
    }

    @Override
    public void pausar() {
        if (tocando) {
            tocando = false;
            pausada = true;
            System.out.println("⏸ Pausado: " + titulo);
        }
    }

    @Override
    public void parar() {
        tocando = false;
        pausada = false;
        System.out.println("Parado: " + titulo);
    }

    @Override
    public int getDuracaoTotal() {
        return duracaoSegundos;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isTocando() {
        return tocando;
    }

    public boolean isPausada() {
        return pausada;
    }

    @Override
    public abstract void reproduzir();
}