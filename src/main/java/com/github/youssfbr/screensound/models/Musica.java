package com.github.youssfbr.screensound.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_musicas")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;

    @ManyToOne
    private Artista artista;

    public Musica() {}

    public Musica(String nomeMusica) {
        titulo = nomeMusica;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Musica{" +
               "id=" + id +
               ", titulo='" + titulo + '\'' +
               ", artista=" + artista.getNome() +
               '}';
    }
}
