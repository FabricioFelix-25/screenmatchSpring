package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.service.ConsultaChatGPT;
import com.fasterxml.jackson.annotation.JsonAlias;
import jdk.jfr.Category;

import java.util.Optional;
import java.util.OptionalDouble;

public class Serie {
    private  String titulo;

    private Integer totalTemporadas;

    private Double avaliacao;

    private Categoria genero;

    private String atores;

    private String poster;

    private String sinopse;


    public Serie(DadosSerie dadosSerie) {
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        try {
            this.avaliacao = dadosSerie.avaliacao() != null ?
                    Double.valueOf(dadosSerie.avaliacao()) : 0.0;
        } catch (NumberFormatException e) {
            this.avaliacao = 0.0;
        }


        String generoStr = dadosSerie.genero();
        if (generoStr != null && !generoStr.isEmpty()) {
            this.genero = Categoria.fromString(generoStr.split(",")[0].trim());
        } else {
            this.genero = Categoria.fromString("Não categorizado");
        }

        this.atores = dadosSerie.atores();
        this.poster = dadosSerie.poster();
        this.sinopse = ConsultaChatGPT.obterTraducao(dadosSerie.sinopse()).trim();


    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    @Override
    public String toString() {
        return "genero=" + genero +
                ", titulo='" + titulo + '\'' +
                ", totalTemporadas=" + totalTemporadas +
                ", avaliacao=" + avaliacao +
                ", atores='" + atores + '\'' +
                ", poster='" + poster + '\'' +
                ", sinopse='" + sinopse + '\'';
    }
}
