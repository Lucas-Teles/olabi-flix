package com.olabi.olabiflix.model.entity;


import com.olabi.olabiflix.model.value.Ratings;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="serie")
public class Serie {
    @Id
    @UuidGenerator
    private UUID id;
    private String title;
    private String totalSeasons;
    @ElementCollection
    private List<String> genre;
    @ElementCollection
    private List<String> writers;
    private String poster;
    @ElementCollection
    private List<String> actors;
    @Embedded
    private Ratings ratings;

    protected Serie(){}

    public Serie(String title, String totalSeasons, List<String> genre, List<String> writers, String poster, List<String> actors, Ratings ratings) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.totalSeasons = totalSeasons;
        this.genre = genre;
        this.writers = writers;
        this.poster = poster;
        this.actors = actors;
        this.ratings = ratings;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(String totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public Ratings getRatings(){
        return ratings;
    }
    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }
}
