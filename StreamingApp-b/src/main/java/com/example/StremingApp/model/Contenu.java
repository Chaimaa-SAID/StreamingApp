package com.example.StremingApp.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contenus")
public class Contenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateConsultation;
    private String type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User utilisateur;

    @ManyToOne
    @JoinColumn(name = "media_id")
    private Media contenu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(User utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Media getContenu() {
        return contenu;
    }

    public void setContenu(Media contenu) {
        this.contenu = contenu;
    }
}
