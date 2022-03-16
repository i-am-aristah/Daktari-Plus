package com.example.daktariplus.model;

public class MedicineModel {

    String id,med_name,med_image;


    public MedicineModel(String id, String med_name, String med_image) {
        this.id = id;
        this.med_name = med_name;
        this.med_image = med_image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMed_name() {
        return med_name;
    }

    public void setMed_name(String med_name) {
        this.med_name = med_name;
    }

    public String getMed_image() {
        return med_image;
    }

    public void setMed_image(String med_image) {
        this.med_image = med_image;
    }
}