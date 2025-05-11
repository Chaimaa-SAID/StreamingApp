package com.example.StremingApp.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "seasons")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;
    private Date releaseDate;

    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Episode> episodes;


    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie series) {
        this.serie = series;
    }

    @Override
    public String toString() {
        return "Season{" +
                "id=" + id +
                ", number=" + number +
                ", releaseDate=" + releaseDate +
                ", series=" + serie +
                '}';
    }
}
