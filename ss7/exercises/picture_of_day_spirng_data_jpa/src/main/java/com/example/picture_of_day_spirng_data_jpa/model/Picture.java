package com.example.picture_of_day_spirng_data_jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int evaluate;
    private String author;
    private String feedBack;
    private int awesome;
    private int great;

    public Picture() {
    }

    public Picture(int id, int evaluate, String author, String feedBack, int awesome, int great) {
        this.id = id;
        this.evaluate = evaluate;
        this.author = author;
        this.feedBack = feedBack;
        this.awesome = awesome;
        this.great = great;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(int evaluate) {
        this.evaluate = evaluate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public int getAwesome() {
        return awesome;
    }

    public void setAwesome(int awesome) {
        this.awesome = awesome;
    }

    public int getGreat() {
        return great;
    }

    public void setGreat(int great) {
        this.great = great;
    }
}
