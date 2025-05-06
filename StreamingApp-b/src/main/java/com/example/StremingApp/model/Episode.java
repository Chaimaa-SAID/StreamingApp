package com.example.StremingApp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private int numero;
    private int duree;
    private String urlStreaming;

    @ManyToOne
    @JoinColumn(name = "season_id") // Foreign key to Season
    private Season season;

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", numero=" + numero +
                ", duree=" + duree +
                ", urlStreaming='" + urlStreaming + '\'' +
                ", season=" + season +
                '}';
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public void setUrlStreaming(String urlStreaming) {
        this.urlStreaming = urlStreaming;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Long getId() {
        return id;
    }

    public Season getSeason() {
        return season;
    }

    public String getUrlStreaming() {
        return urlStreaming;
    }

    public int getDuree() {
        return duree;
    }

    public String getTitre() {
        return titre;
    }

    public int getNumero() {
        return numero;
    }
}

