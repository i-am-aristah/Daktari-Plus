package com.example.daktariplus.model;

public class SpecificMedicine {

    String id, medicine_name, med_pic, pharmacy_name, med_county,med_location;

    public SpecificMedicine(String id, String medicine_name, String med_pic, String pharmacy_name, String med_county, String med_location) {
        this.id = id;
        this.medicine_name = medicine_name;
        this.med_pic = med_pic;
        this.pharmacy_name = pharmacy_name;
        this.med_county = med_county;
        this.med_location = med_location;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public String getMed_pic() {
        return med_pic;
    }

    public void setMed_pic(String med_pic) {
        this.med_pic = med_pic;
    }

    public String getPharmacy_name() {
        return pharmacy_name;
    }

    public void setPharmacy_name(String pharmacy_name) {
        this.pharmacy_name = pharmacy_name;
    }

    public String getMed_county() {
        return med_county;
    }

    public void setMed_county(String med_county) {
        this.med_county = med_county;
    }

    public String getMed_location() {
        return med_location;
    }

    public void setMed_location(String med_location) {
        this.med_location = med_location;
    }
}