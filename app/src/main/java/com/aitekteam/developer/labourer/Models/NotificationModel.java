package com.aitekteam.developer.labourer.Models;

import java.io.Serializable;

public class NotificationModel implements Serializable {
    private String sender_id, receiver_id, message, sender_name, sender_photo;
    private int status;
    private long timestamp;

    public NotificationModel() {
    }

    public NotificationModel(String sender_id, String receiver_id, String message, String sender_name, String sender_photo, int status, long timestamp) {
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.message = message;
        this.sender_name = sender_name;
        this.sender_photo = sender_photo;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getSender_photo() {
        return sender_photo;
    }

    public void setSender_photo(String sender_photo) {
        this.sender_photo = sender_photo;
    }

    public String getSender_id() {
        return sender_id;
    }

    public void setSender_id(String sender_id) {
        this.sender_id = sender_id;
    }

    public String getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(String receiver_id) {
        this.receiver_id = receiver_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
