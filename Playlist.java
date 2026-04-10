import java.util.ArrayList;

class Playlist {

    private String nome;
    private ArrayList<Musica> musicas;

    // Construtor
    public Playlist(String nome) {
        setNome(nome);
        this.musicas = new ArrayList<>();
    }

    // Getter
    public String getNome() { return nome; }

    // Setter com validação
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da playlist inválido.");
        }
        this.nome = nome.trim();
    }

    public void adicionarMusica(Musica musica) {
        if (musica == null) {
            System.out.println("Música inválida.");
            return;
        }
        musicas.add(musica);
        System.out.println("Música adicionada!");
    }

    public void removerMusica(int indice) {
        if (indice >= 0 && indice < musicas.size()) {
            musicas.remove(indice);
            System.out.println("Música removida!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void listarMusicas() {
        if (musicas.isEmpty()) {
            System.out.println("Playlist vazia.");
            return;
        }

        for (int i = 0; i < musicas.size(); i++) {
            System.out.print((i + 1) + ". ");
            musicas.get(i).exibir();
        }
    }

    public int getDuracaoTotal() {
        int total = 0;
        for (Musica m : musicas) {
            total += m.getDuracaoSegundos();
        }
        return total;
    }

    public int getQuantidadeMusicas() {
        return musicas.size();
    }
}