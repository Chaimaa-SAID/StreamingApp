package com.example.StremingApp.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Movie extends Media {
    private String realisateur;
    private int duree;

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public int getDuree() {
        return duree;
    }
}
