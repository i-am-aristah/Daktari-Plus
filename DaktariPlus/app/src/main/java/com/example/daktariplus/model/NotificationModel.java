package com.example.daktariplus.model;

public class NotificationModel{

    String id, details,region,author,image,views;

    public NotificationModel(String id, String details, String region, String author, String image, String views) {
        this.id = id;
        this.details = details;
        this.region = region;
        this.author = author;
        this.image = image;
        this.views = views;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }
}