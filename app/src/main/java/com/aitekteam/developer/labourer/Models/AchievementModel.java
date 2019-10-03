package com.aitekteam.developer.labourer.Models;

import java.io.Serializable;

public class AchievementModel implements Serializable {
    private String title, location;
    private int point, status, type;
    private double location_lat, location_lon;

    public AchievementModel() {
    }

    public AchievementModel(String title, String location, int point, int status, int type, double location_lat, double location_lon) {
        this.title = title;
        this.location = location;
        this.point = point;
        this.status = status;
        this.type = type;
        this.location_lat = location_lat;
        this.location_lon = location_lon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public double getLocation_lat() {
        return location_lat;
    }

    public void setLocation_lat(double location_lat) {
        this.location_lat = location_lat;
    }

    public double getLocation_lon() {
        return location_lon;
    }

    public void setLocation_lon(double location_lon) {
        this.location_lon = location_lon;
    }
}
