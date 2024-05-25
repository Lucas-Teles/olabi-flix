package com.olabi.olabiflix.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name="serie")
public class Serie {
    @Id
    @UuidGenerator
    private UUID id;
    private String title;
    private String totalSeasons;
    private ArrayList<String> genre;
    private ArrayList<String> writers;
    private String poster;
    private ArrayList<String> actors;

    protected Serie(){}

    public Serie(String title, String totalSeasons, ArrayList<String> genre, ArrayList<String> writers, String poster, ArrayList<String> actors) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.totalSeasons = totalSeasons;
        this.genre = genre;
        this.writers = writers;
        this.poster = poster;
        this.actors = actors;
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

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public ArrayList<String> getWriters() {
        return writers;
    }

    public void setWriters(ArrayList<String> writers) {
        this.writers = writers;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }
}
