package com.example.StremingApp.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "media")
@Inheritance(strategy = InheritanceType.JOINED)  // Ajout de la stratégie d'héritage JOINED
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;
    private Date dateSortie;
    private String langue;
    private boolean estDisponible;
    private String urlStreaming;

    // Getters et setters

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public String getLangue() {
        return langue;
    }

    public boolean isEstDisponible() {
        return estDisponible;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public void setEstDisponible(boolean estDisponible) {
        this.estDisponible = estDisponible;
    }
    public String getUrlStreaming() {
        return urlStreaming;
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", dateSortie=" + dateSortie +
                ", langue='" + langue + '\'' +
                ", estDisponible=" + estDisponible +
                ", urlStreaming='" + urlStreaming + '\'' +
                '}';
    }

    public void setUrlStreaming(String urlStreaming) {
        this.urlStreaming = urlStreaming;
    }


}
