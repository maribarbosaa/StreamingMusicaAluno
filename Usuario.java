import java.util.ArrayList;

public class Usuario {
    protected String nome;
    protected String email;
    protected int reproducoes;

    public Usuario(String nome, String email) {
        this.nome = nome;
        validarEmail(email);
        this.email = email;
        this.reproducoes = 0;
    }

    public void reproduzirMusica(Musica musica) {
        reproducoes++;
        System.out.println(nome + " está ouvindo: " + musica.getTitulo());
    }

    public final void validarEmail(String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email inválido!");
        }
    }

    public String getNome() {
        return nome;
    }

    public int getReproducoes() {
        return reproducoes;
    }
}