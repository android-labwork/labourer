package com.aitekteam.developer.labourer.Models;

import java.io.Serializable;

public class User implements Serializable {
    private String userId;
    private String userFullName;
    private String userNik;
    private String userPict;
    private String userEmail;
    private String userPassword;
    private String userRole;
    private String userSkill;
    private String userDescription;
    private String userHomeAddress;
    private int userEperiencePoin;

    public String getUserId() {
        return userId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public String getUserNik() {
        return userNik;
    }

    public String getUserPict() {
        return userPict;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public String getUserSkill() {
        return userSkill;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public String getUserHomeAddress() {
        return userHomeAddress;
    }

    public int getUserEperiencePoin() {
        return userEperiencePoin;
    }

    public User(String userId, String userFullName, String userNik, String userPict, String userEmail, String userPassword, String userRole, String userSkill, String userDescription, String userHomeAddress, int userEperiencePoin) {
        this.userId = userId;
        this.userFullName = userFullName;
        this.userNik = userNik;
        this.userPict = userPict;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userRole = userRole;
        this.userSkill = userSkill;
        this.userDescription = userDescription;
        this.userHomeAddress = userHomeAddress;
        this.userEperiencePoin = userEperiencePoin;
    }

    public User() {
    }
}
