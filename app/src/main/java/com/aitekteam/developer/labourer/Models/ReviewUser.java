package com.aitekteam.developer.labourer.Models;

public class ReviewUser {
    private String revId;
    private String revTitle;
    private int revStar;
    private String userId;
    private String userName;

    public String getRevId() {
        return revId;
    }

    public String getRevTitle() {
        return revTitle;
    }

    public int getRevStar() {
        return revStar;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public ReviewUser(String revId, String revTitle, int revStar, String userId, String userName) {
        this.revId = revId;
        this.revTitle = revTitle;
        this.revStar = revStar;
        this.userId = userId;
        this.userName = userName;
    }
}
