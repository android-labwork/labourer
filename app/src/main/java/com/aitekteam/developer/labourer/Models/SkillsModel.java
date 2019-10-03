package com.aitekteam.developer.labourer.Models;

import java.io.Serializable;

public class SkillsModel implements Serializable {
    private String title;
    private int level, point, status, type;

    public SkillsModel() {
    }

    public SkillsModel(String title, int level, int point, int status, int type) {
        this.title = title;
        this.level = level;
        this.point = point;
        this.status = status;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
