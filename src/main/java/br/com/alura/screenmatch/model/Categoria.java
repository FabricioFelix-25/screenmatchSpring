package br.com.alura.screenmatch.model;

public enum Categoria {

    ACAO("Action", "Ação"),
    ROMANCE("Romance", "Romance"),
    COMEDIA("Comedy", "Comédia"),
    DRAMA("Drama", "Drama"),
    CRIME("Crime", "Crime"),
    NAO_DEFINIDO("N/A", "Não Definido");

    private final String categoriaOmdb;
    private final String categoriaPortugues;

    Categoria(String categoriaOmdb, String categoriaPortugues) {
        this.categoriaOmdb = categoriaOmdb;
        this.categoriaPortugues = categoriaPortugues;
    }

    // Getter para o nome da categoria em português
    public String getCategoriaPortugues() {
        return categoriaPortugues;
    }

    /**
     * Converte uma String (seja em inglês ou português) para o enum Categoria correspondente.
     * Não diferencia maiúsculas de minúsculas.
     *
     * @param text A string a ser convertida.
     * @return O enum Categoria correspondente.
     * @throws IllegalArgumentException se nenhuma categoria for encontrada.
     */
    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text) ||
                    categoria.categoriaPortugues.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}