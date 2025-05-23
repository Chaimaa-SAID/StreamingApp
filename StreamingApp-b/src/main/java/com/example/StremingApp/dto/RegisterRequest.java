package com.example.StremingApp.dto;

public class RegisterRequest {
    private String nom;
    private String email;
    private String password;
    private String role; // Nouveau champ pour le rôle

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {  // ✔ nom cohérent avec le champ
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
