package com.example.daktariplus.model;

import com.google.gson.annotations.SerializedName;

public class AppointmentModel {
    String doctor_name, appointment_time, appointment_status,patient_name;
    int patient_id;
    @SerializedName("id")
    int appointment_id;


    public AppointmentModel(String doctor_name, String appointment_time, String appointment_status, String patient_name, int patient_id, int appointment_id) {
        this.doctor_name = doctor_name;
        this.appointment_time = appointment_time;
        this.appointment_status = appointment_status;
        this.patient_name = patient_name;
        this.patient_id = patient_id;
        this.appointment_id = appointment_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(String appointment_time) {
        this.appointment_time = appointment_time;
    }

    public String getAppointment_status() {
        return appointment_status;
    }

    public void setAppointment_status(String appointment_status) {
        this.appointment_status = appointment_status;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }
}
