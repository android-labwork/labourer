package com.aitekteam.developer.labourer.Models;

import java.io.Serializable;

public class ReviewModel implements Serializable {
    private String title, description;
    private long avg_review;
    private int status;

    public ReviewModel() {
    }

    public ReviewModel(String title, String description, long avg_review, int status) {
        this.title = title;
        this.description = description;
        this.avg_review = avg_review;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getAvg_review() {
        return avg_review;
    }

    public void setAvg_review(long avg_review) {
        this.avg_review = avg_review;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
