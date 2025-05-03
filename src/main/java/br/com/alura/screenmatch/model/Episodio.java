package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDate;

public class Episodio {

    private Integer temporada;
    private String titulo;
    private Integer numeroEpisodio;
    private String avaliacao;
    private LocalDate dataLançamento;

    public Episodio(Integer numeroTemporada, DadosEpisodio dadosEpisodio) {
        this.temporada = numeroTemporada;
        this.titulo = dadosEpisodio.titulo();
        this.numeroEpisodio = dadosEpisodio.numero();
        this.avaliacao = dadosEpisodio.avaliacao();
        try {

        this.dataLançamento = LocalDate.parse(dadosEpisodio.dataLançamento());
        } catch (Exception e) {
            this.dataLançamento = null;
        }
    }

    public LocalDate getDataLançamento() {
        return dataLançamento;
    }

    public void setDataLançamento(LocalDate dataLançamento) {
        this.dataLançamento = dataLançamento;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(Integer numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    @Override
    public String toString() {
        return
                "Temporada= " + temporada +
                ", titulo= " + titulo + '\'' +
                ", numeroEpisodio= " + numeroEpisodio +
                ", avaliacao= " + avaliacao + '\'' +
                ", dataLançamento= " + dataLançamento ;

    }
}
