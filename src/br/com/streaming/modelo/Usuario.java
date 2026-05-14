package br.com.streaming.modelo;

import java.util.ArrayList;

public class Usuario {

    protected String nome;
    protected String email;
    protected int reproducoes;
    protected ArrayList<Musica> historico;

    public Usuario(String nome, String email) {
        this.nome = nome;
        validarEmail(email);
        this.email = email;
        this.reproducoes = 0;
        this.historico = new ArrayList<>();
    }

    public void reproduzirMusica(Musica musica) {
        reproducoes++;
        historico.add(musica);
        musica.reproduzir();
        System.out.println(" Ouvinte: " + nome);
    }

    public final void validarEmail(String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email inválido: " + email);
        }
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getReproducoes() {
        return reproducoes;
    }

    public ArrayList<Musica> getHistorico() {
        return historico;
    }
}