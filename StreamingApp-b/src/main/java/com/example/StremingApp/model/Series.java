package com.example.StremingApp.model;


import jakarta.persistence.*;

@Entity
@Table(name = "series")
public class Series extends Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private int nombreSaisons;

    public int getNombreSaisons() {
        return nombreSaisons;
    }

    public String getNom() {
        return nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombreSaisons(int nombreSaisons) {
        this.nombreSaisons = nombreSaisons;
    }

    @Override
    public String toString() {
        return "Series{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", nombreSaisons=" + nombreSaisons +
                '}';
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
