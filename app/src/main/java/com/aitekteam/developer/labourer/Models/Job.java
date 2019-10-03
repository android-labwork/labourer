package com.aitekteam.developer.labourer.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Job {
    private ArrayList<String> photos, benefits, arrUserId;
    private String jobId, title, description, location, userId, userName;
    private int duration_of_work, count_of_worker, price, status, type, experiencePoin;
    private double location_lat, location_lon;

    public Job() {}

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

    public ArrayList<String> getArrUserId() {
        return arrUserId;
    }

    public void setArrUserId(ArrayList<String> arrUserId) {
        this.arrUserId = arrUserId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getExperiencePoin() {
        return experiencePoin;
    }

    public void setExperiencePoin(int experiencePoin) {
        this.experiencePoin = experiencePoin;
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

    public Job(ArrayList<String> photos, ArrayList<String> benefits, ArrayList<String> arrUserId, String jobId, String title, String description, String location, String userId, String userName, int duration_of_work, int count_of_worker, int price, int status, int type, int experiencePoin, double location_lat, double location_lon) {
        this.photos = photos;
        this.benefits = benefits;
        this.arrUserId = arrUserId;
        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.userId = userId;
        this.userName = userName;
        this.duration_of_work = duration_of_work;
        this.count_of_worker = count_of_worker;
        this.price = price;
        this.status = status;
        this.type = type;
        this.experiencePoin = experiencePoin;
        this.location_lat = location_lat;
        this.location_lon = location_lon;
    }
}
