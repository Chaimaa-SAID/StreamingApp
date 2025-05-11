package com.example.StremingApp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "serie")
public class Serie extends Media {
    private String nom;
    private int nombreSaisons;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Season> seasons;


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombreSaisons() {
        return nombreSaisons;
    }

    public void setNombreSaisons(int nombreSaisons) {
        this.nombreSaisons = nombreSaisons;
    }

    @Override
    public String toString() {
        return "Series{" +
                "nom='" + nom + '\'' +
                ", nombreSaisons=" + nombreSaisons +
                "} " + super.toString();
    }
}
