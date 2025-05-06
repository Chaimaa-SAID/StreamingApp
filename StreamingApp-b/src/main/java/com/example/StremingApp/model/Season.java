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

    @ManyToOne
    @JoinColumn(name = "series_id")
    private Series series;

    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Episode> episodes;

    public Long getId() {
        return id;
    }

    public Series getSeries() {
        return series;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Season{" +
                "id=" + id +
                ", number=" + number +
                ", releaseDate=" + releaseDate +
                ", series=" + series +
                '}';
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
