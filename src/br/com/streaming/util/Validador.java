package br.com.streaming.util;

public class Validador {

    public static boolean validarEmail(String email) {
        if (email == null || email.isEmpty()) return false;
        int arroba = email.indexOf("@");
        if (arroba <= 0) return false;
        String dominio = email.substring(arroba + 1);
        return dominio.contains(".");
    }

    public static boolean validarNome(String nome) {
        return nome != null && nome.trim().length() >= 2;
    }

    public static boolean validarDuracao(int segundos) {
        return segundos > 0;
    }

    public static boolean validarTitulo(String titulo) {
        return titulo != null && !titulo.trim().isEmpty();
    }


    public static void validarEmailOuLancar(String email) {
        if (!validarEmail(email)) {
            throw new IllegalArgumentException("Email inválido: " + email);
        }
    }


    public static void validarNomeOuLancar(String nome) {
        if (!validarNome(nome)) {
            throw new IllegalArgumentException("Nome inválido: deve ter ao menos 2 caracteres.");
        }
    }
}