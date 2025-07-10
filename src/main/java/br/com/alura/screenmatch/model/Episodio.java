package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

import java.time.LocalDate;
@Entity
@Table(name = "episodios")
public class Episodio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer temporada;
    private String titulo;
    private Integer numeroEpisodio;
    private Double avaliacao;
    private LocalDate dataLançamento;

    @ManyToOne
    private Serie serie;

    public Episodio(){

    }

    public Episodio(Integer numeroTemporada, DadosEpisodio dadosEpisodio) {
        this.temporada = numeroTemporada;
        this.titulo = dadosEpisodio.titulo();
        this.numeroEpisodio = dadosEpisodio.numero();
        try {
            this.avaliacao = Double.valueOf(dadosEpisodio.avaliacao());
        } catch (NumberFormatException ex) {
            this.avaliacao = 0.0;
        }
        try {

        this.dataLançamento = LocalDate.parse(dadosEpisodio.dataLançamento());
        } catch (Exception e) {
            this.dataLançamento = null;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public LocalDate getDataLançamento() {
        return dataLançamento;
    }

    public void setDataLançamento(LocalDate dataLançamento) {
        this.dataLançamento = dataLançamento;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
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
