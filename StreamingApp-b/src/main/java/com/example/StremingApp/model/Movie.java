package com.example.StremingApp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "movies")
public class Movie extends Media {
    private String realisateur;
    private int duree;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VideoFile> videoFiles;

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "realisateur='" + realisateur + '\'' +
                ", duree=" + duree +
                "} " + super.toString();
    }
}
