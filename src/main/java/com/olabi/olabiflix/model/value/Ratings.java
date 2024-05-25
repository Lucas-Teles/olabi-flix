package com.olabi.olabiflix.model.value;
import jakarta.persistence.Embeddable;

@Embeddable
public class Ratings {
    private String rating;
    private String likes;

    protected Ratings(){}

    public Ratings(String rating, String likes) {
        this.rating = rating;
        this.likes = likes;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }
}
