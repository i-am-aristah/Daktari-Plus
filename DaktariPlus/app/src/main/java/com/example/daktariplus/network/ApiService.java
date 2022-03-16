package com.example.daktariplus.network;

import com.example.daktariplus.model.AppointmentModel;
import com.example.daktariplus.model.Doctor;
import com.example.daktariplus.model.LoginModel;
import com.example.daktariplus.model.MedicalRecordModel;
import com.example.daktariplus.model.MedicineModel;
import com.example.daktariplus.model.NotificationModel;
import com.example.daktariplus.model.Specialist;
import com.example.daktariplus.model.SpecificMedicine;
import com.example.daktariplus.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {

    @GET("daktariplus")
    Call<UserModel> getUser();

    //Register user
    @FormUrlEncoded
    @POST("register")
    Call<UserModel> registerUser(@Field("name") String username,
                               @Field("email") String email,
                               @Field("password") String password,
                               @Field("password_confirmation") String confirmpassword);

    //Login user]
    @FormUrlEncoded
    @POST("login")
    Call<LoginModel> loginUser(@Field("email") String email,
                               @Field("password") String password);

    //Get all Specialists
    @GET("specialists")
    Call <List<Specialist>> getSpecialist();


    //Get Doctors
    @GET("doctors/{name}")
    Call<List<Doctor>> getDoctors(@Path("name") String name);

    //Get Notifications
    @GET("notifications")
    Call<List<NotificationModel>> getNotifications();

    //Get MedicalRecords
    @GET("patientmedicalrecords/{patient_id}")
    Call<List<MedicalRecordModel>> getPatientMedicalRecords(@Path("patient_id") String patient_id);

    //Get Appointment History
    @GET("patientappointmentsrecords/{patient_id}")
    Call<List<AppointmentModel>> getAppointmentRecord(@Path("patient_id") String patient_id);


    //Get Doctor Appointment Records
    @GET("doctorappointmentsrecords/{doctor_name}")
    Call<List<AppointmentModel>> getDocAppointmentRecord(@Path("doctor_name") String doctor_name);

    //Get Doctor Appointment History
    @GET("doctorappointmentsrecords_history/{doctor_name}")
    Call<List<AppointmentModel>> getDocAppointmentHistory(@Path("doctor_name") String doctor_name);



    //Book Appointment
    @FormUrlEncoded
    @POST("patientappointmentsrecords")
    Call<List<AppointmentModel>> bookAppointment(@Field("doctor_name") String docName,
                                                 @Field("appointment_time") String appointment_time,
                                                 @Field("appointment_status") String appointment_status,
                                                 @Field("patient_id") String patient_id,
                                                 @Field("patient_name") String patient_name);

    //Update Appointment
    @FormUrlEncoded
    @PUT("updatepatientappointmentsrecords/{id}")
    Call<AppointmentModel> updateAppointment(@Path("id") int id,@Field("appointment_status") String appointment_status);

    //Get all Doctors
    @GET("doctors")
    Call<List<Doctor>> getAllDoctors();

    //Get All Medicines
    @GET("allmedicine")
    Call<List<MedicineModel>> getAllMedicine();

    //@Get Specific Medicines
    @GET("specificmed/{med_name}")
    Call <List<SpecificMedicine>> getspecificMed(@Path("med_name") String medName);



    //Add Medical Record
    @FormUrlEncoded
    @POST("patientmedicalrecords")
    Call<MedicalRecordModel> addMedicalRecord(@Field("treatment_date") String treatment_date,
                                                 @Field("hospital_name") String hospital_name,
                                                 @Field("patient_id") String patient_id,
                                                 @Field("fee_charged") String fee_charged,
                                                 @Field("medical_condition") String medical_condition,
                                                 @Field("doctor_id") String doctor_id);


    @GET()
    Call<Response> getdetail();

}
