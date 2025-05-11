package com.example.StremingApp.model;

import jakarta.persistence.*;

import java.util.List;

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
    @JoinColumn(name = "season_id")
    private Season season;

    @OneToMany(mappedBy = "episode", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VideoFile> videoFiles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getUrlStreaming() {
        return urlStreaming;
    }

    public void setUrlStreaming(String urlStreaming) {
        this.urlStreaming = urlStreaming;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
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
}
