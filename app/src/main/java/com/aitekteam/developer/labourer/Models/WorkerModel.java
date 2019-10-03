package com.aitekteam.developer.labourer.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class WorkerModel implements Serializable {
    private String photo, name;
    private ArrayList skills;
    private long avg_review;

    public WorkerModel(String photo, String name, ArrayList skills, long avg_review) {
        this.photo = photo;
        this.name = name;
        this.skills = skills;
        this.avg_review = avg_review;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getSkills() {
        return skills;
    }

    public void setSkills(ArrayList skills) {
        this.skills = skills;
    }

    public long getAvg_review() {
        return avg_review;
    }

    public void setAvg_review(long avg_review) {
        this.avg_review = avg_review;
    }
}
