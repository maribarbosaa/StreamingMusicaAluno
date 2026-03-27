import java.util.ArrayList;

class Playlist {

    String nome;
    ArrayList<Musica> musicas = new ArrayList<>();

    void adicionarMusica(Musica musica) {
        musicas.add(musica);
        System.out.println("Música adicionada à playlist!");
    }

    void removerMusica(int indice) {
        if (indice >= 0 && indice < musicas.size()) {
            musicas.remove(indice);
            System.out.println("Música removida!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    void listarMusicas() {
        if (musicas.isEmpty()) {
            System.out.println("Playlist vazia.");
            return;
        }

        for (int i = 0; i < musicas.size(); i++) {
            System.out.print((i + 1) + ". ");
            musicas.get(i).exibir();
        }
    }

    int getDuracaoTotal() {
        int total = 0;
        for (Musica m : musicas) {
            total += m.duracaoSegundos;
        }
        return total;
    }

    int getQuantidadeMusicas() {
        return musicas.size();
    }
}
