package com.aitekteam.developer.labourer.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class JobModel implements Serializable {
    private ArrayList<String> photos, benefits, workers;
    private String title, description, location, userId;
    private int duration_of_work, count_of_worker, price, status, type;
    private double location_lat, location_lon;

    public JobModel() {}

    public JobModel(ArrayList<String> photos, ArrayList<String> benefits, ArrayList<String> workers,
                    String userId, String title, String description, String location, int duration_of_work,
                    int count_of_worker, int price, int status, int type, double location_lat, double location_lon) {
        this.photos = photos;
        this.benefits = benefits;
        this.workers = workers;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.duration_of_work = duration_of_work;
        this.count_of_worker = count_of_worker;
        this.price = price;
        this.status = status;
        this.type = type;
        this.location_lat = location_lat;
        this.location_lon = location_lon;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ArrayList<String> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<String> photos) {
        this.photos = photos;
    }

    public ArrayList<String> getBenefits() {
        return benefits;
    }

    public void setBenefits(ArrayList<String> benefits) {
        this.benefits = benefits;
    }

    public ArrayList<String> getWorkers() {
        return workers;
    }

    public void setWorkers(ArrayList<String> workers) {
        this.workers = workers;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDuration_of_work() {
        return duration_of_work;
    }

    public void setDuration_of_work(int duration_of_work) {
        this.duration_of_work = duration_of_work;
    }

    public int getCount_of_worker() {
        return count_of_worker;
    }

    public void setCount_of_worker(int count_of_worker) {
        this.count_of_worker = count_of_worker;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
