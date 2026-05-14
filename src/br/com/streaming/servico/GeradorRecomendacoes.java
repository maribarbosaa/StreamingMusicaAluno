package br.com.streaming.servico;

import br.com.streaming.modelo.Musica;
import br.com.streaming.modelo.Usuario;
import java.util.ArrayList;

public class GeradorRecomendacoes {

    private ArrayList<Musica> todasMusicas;

    public GeradorRecomendacoes(ArrayList<Musica> todasMusicas) {
        this.todasMusicas = todasMusicas;
    }

    public ArrayList<Musica> recomendar(Usuario usuario, int quantidade) {
        ArrayList<Musica> historico = usuario.getHistorico();
        ArrayList<Musica> recomendadas = new ArrayList<>();

        for (Musica musica : todasMusicas) {
            if (!historico.contains(musica)) {
                recomendadas.add(musica);
                if (recomendadas.size() == quantidade) {
                    break;
                }
            }
        }

        if (recomendadas.isEmpty()) {
            System.out.println("🎵 Você já ouviu tudo! Recomendando do início...");
            for (int i = 0; i < quantidade && i < todasMusicas.size(); i++) {
                recomendadas.add(todasMusicas.get(i));
            }
        }

        return recomendadas;
    }

    public void exibirRecomendacoes(Usuario usuario, int quantidade) {
        System.out.println("\n Recomendações para " + usuario.getNome() + ":");
        ArrayList<Musica> lista = recomendar(usuario, quantidade);

        if (lista.isEmpty()) {
            System.out.println("  Nenhuma recomendação disponível.");
        } else {
            int i = 1;
            for (Musica m : lista) {
                System.out.println("  " + i + ". " + m.getTitulo() + " - " + m.getArtista());
                i++;
            }
        }
    }
}