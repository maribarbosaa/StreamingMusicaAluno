class Musica {

    private String titulo;
    private String artista;
    private int duracaoSegundos;
    private String genero;

    private static final String[] GENEROS_VALIDOS = {
        "Pop", "Rock", "Jazz", "Eletrônica", "Hip-Hop", "Clássica"
    };

    // Construtor padrão
    public Musica() {}

    // Construtor parametrizado
    public Musica(String titulo, String artista, int duracaoSegundos, String genero) {
        setTitulo(titulo);
        setArtista(artista);
        setDuracaoSegundos(duracaoSegundos);
        setGenero(genero);
    }

    // Getters
    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }
    public int getDuracaoSegundos() { return duracaoSegundos; }
    public String getGenero() { return genero; }

    // Setters com validação
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título inválido.");
        }
        this.titulo = titulo.trim();
    }

    public void setArtista(String artista) {
        if (artista == null || artista.trim().isEmpty()) {
            throw new IllegalArgumentException("Artista inválido.");
        }
        this.artista = artista.trim();
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        if (duracaoSegundos <= 0 || duracaoSegundos >= 3600) {
            throw new IllegalArgumentException("Duração deve estar entre 1 e 3599 segundos.");
        }
        this.duracaoSegundos = duracaoSegundos;
    }

    public void setGenero(String genero) {
        if (genero == null) {
            throw new IllegalArgumentException("Gênero inválido.");
        }

        for (String g : GENEROS_VALIDOS) {
            if (g.equalsIgnoreCase(genero.trim())) {
                this.genero = g;
                return;
            }
        }

        throw new IllegalArgumentException("Gênero inválido.");
    }

    // Métodos
    void exibir() {
        System.out.println(titulo + " | " + artista + " | " + getDuracaoFormatada() + " | " + genero);
    }

    String getDuracaoFormatada() {
        int minutos = duracaoSegundos / 60;
        int segundos = duracaoSegundos % 60;
        return String.format("%d:%02d", minutos, segundos);
    }

    boolean contemTitulo(String busca) {
        return titulo.toLowerCase().contains(busca.toLowerCase());
    }

    boolean contemArtista(String busca) {
        return artista.toLowerCase().contains(busca.toLowerCase());
    }
}