package com.aitekteam.developer.labourer.Models;

public class Achivement {
    private String achId;
    private String achTitle;
    private String achDescripion;
    private String achPict;
    private int achPoin;

    public String getAchId() {
        return achId;
    }

    public String getAchTitle() {
        return achTitle;
    }

    public String getAchDescripion() {
        return achDescripion;
    }

    public String getAchPict() {
        return achPict;
    }

    public int getAchPoin() {
        return achPoin;
    }

    public Achivement(String achId, String achTitle, String achDescripion, String achPict, int achPoin) {
        this.achId = achId;
        this.achTitle = achTitle;
        this.achDescripion = achDescripion;
        this.achPict = achPict;
        this.achPoin = achPoin;
    }
}
