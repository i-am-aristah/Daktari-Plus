package com.example.daktariplus;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.daktariplus.model.AppointmentModel;
import com.example.daktariplus.network.ApiClient;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingAppointmentTimeSlot extends AppCompatActivity implements View.OnClickListener{

    Button btn_bk_appointment;
    ImageView docPic;
    TextView docName, docLocation;
    TextView txt_e_t1,txt_e_t2,txt_e_t3,txt_e_t4, txt_m_t1,txt_m_t2,txt_m_t3;


    String patient_id;
    String doctor_name;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String SHAREPREFFILE;
    String patient_name;

    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_appointment_time_slot);


        init();

        preferences = getSharedPreferences(SHAREPREFFILE,0);
       patient_id = preferences.getString("user_id","1");
       patient_name = preferences.getString("username","username");

        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //LocalDateTime now = LocalDateTime.now();

        //Toast.makeText(getApplicationContext(), dtf.format(now), Toast.LENGTH_SHORT).show();

        //date = dtf.format(now);

       calendar = Calendar.getInstance();
       dateFormat = new SimpleDateFormat("dd/MM/yyyy");
       date = dateFormat.format(calendar.getTime());





        Bundle bundle = getIntent().getExtras();
        assert bundle != null;

        doctor_name = bundle.getString("doc_name");
        String doctor_image = bundle.getString("doc_image");
        String doctor_location = bundle.getString("doc_location");


        btn_bk_appointment.setOnClickListener(this);
        txt_e_t1.setOnClickListener(this);
        txt_e_t2.setOnClickListener(this);
        txt_e_t3.setOnClickListener(this);
        txt_e_t4.setOnClickListener(this);
        txt_m_t1.setOnClickListener(this);
        txt_m_t2.setOnClickListener(this);
        txt_m_t3.setOnClickListener(this);


        Glide.with(getApplicationContext())
                .load(doctor_image)
                .placeholder(R.drawable.load)
                .into(docPic);


        docName.setText(doctor_name);
        docLocation.setText(doctor_location);



    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btn_bk_appointment:

                Call<List<AppointmentModel>> call = ApiClient.getApiService().bookAppointment(doctor_name,date,"0",patient_id,patient_name);

                call.enqueue(new Callback<List<AppointmentModel>>() {
                    @Override
                    public void onResponse(Call<List<AppointmentModel>> call, Response<List<AppointmentModel>> response) {

                        startActivity(new Intent(getApplicationContext(),AppointmentBookingConfirmation.class));

                    }

                    @Override
                    public void onFailure(Call<List<AppointmentModel>> call, Throwable t) {

                        Toast.makeText(getApplicationContext(),"Appointment Booking Successful!!",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(),AppointmentBookingConfirmation.class));

                    }
                });
                break;
            case R.id.txt_e_t1:
                txt_e_t1.setBackgroundColor(500117);
                txt_e_t2.setBackgroundColor(Color.WHITE);
                txt_e_t3.setBackgroundColor(Color.WHITE);
                txt_e_t4.setBackgroundColor(Color.WHITE);
                txt_m_t1.setBackgroundColor(Color.WHITE);
                txt_m_t2.setBackgroundColor(Color.WHITE);
                txt_m_t3.setBackgroundColor(Color.WHITE);
                break;
            case R.id.txt_e_t2:
                txt_e_t2.setBackgroundColor(500117);
                txt_e_t1.setBackgroundColor(Color.WHITE);
                txt_e_t3.setBackgroundColor(Color.WHITE);
                txt_e_t4.setBackgroundColor(Color.WHITE);
                txt_m_t1.setBackgroundColor(Color.WHITE);
                txt_m_t2.setBackgroundColor(Color.WHITE);
                txt_m_t3.setBackgroundColor(Color.WHITE);
                break;
            case R.id.txt_e_t3:
                txt_e_t3.setBackgroundColor(500117);
                txt_e_t1.setBackgroundColor(Color.WHITE);
                txt_e_t2.setBackgroundColor(Color.WHITE);
                txt_e_t4.setBackgroundColor(Color.WHITE);
                txt_m_t1.setBackgroundColor(Color.WHITE);
                txt_m_t2.setBackgroundColor(Color.WHITE);
                txt_m_t3.setBackgroundColor(Color.WHITE);
                break;
            case R.id.txt_e_t4:
                txt_e_t4.setBackgroundColor(500117);
                txt_e_t1.setBackgroundColor(Color.WHITE);
                txt_e_t2.setBackgroundColor(Color.WHITE);
                txt_e_t3.setBackgroundColor(Color.WHITE);
                txt_m_t1.setBackgroundColor(Color.WHITE);
                txt_m_t2.setBackgroundColor(Color.WHITE);
                txt_m_t3.setBackgroundColor(Color.WHITE);
                break;
            case R.id.txt_m_t1:
                txt_m_t1.setBackgroundColor(500117);
                txt_e_t1.setBackgroundColor(Color.WHITE);
                txt_e_t2.setBackgroundColor(Color.WHITE);
                txt_e_t3.setBackgroundColor(Color.WHITE);
                txt_e_t4.setBackgroundColor(Color.WHITE);
                txt_m_t2.setBackgroundColor(Color.WHITE);
                txt_m_t3.setBackgroundColor(Color.WHITE);

                break;
            case R.id.txt_m_t2:
                txt_m_t2.setBackgroundColor(500117);
                txt_e_t1.setBackgroundColor(Color.WHITE);
                txt_e_t2.setBackgroundColor(Color.WHITE);
                txt_e_t3.setBackgroundColor(Color.WHITE);
                txt_e_t4.setBackgroundColor(Color.WHITE);
                txt_m_t1.setBackgroundColor(Color.WHITE);
                txt_m_t3.setBackgroundColor(Color.WHITE);
                break;
            case R.id.txt_m_t3:
                txt_m_t3.setBackgroundColor(500117);
                txt_e_t1.setBackgroundColor(Color.WHITE);
                txt_e_t2.setBackgroundColor(Color.WHITE);
                txt_e_t3.setBackgroundColor(Color.WHITE);
                txt_e_t4.setBackgroundColor(Color.WHITE);
                txt_m_t1.setBackgroundColor(Color.WHITE);
                txt_m_t2.setBackgroundColor(Color.WHITE);
                break;
        }

    }


    public void init()
    {
        btn_bk_appointment = findViewById(R.id.btn_bk_appointment);

        docPic = findViewById(R.id.img_docImage_apo);
        docName = findViewById(R.id.txt_docName_apo);
        docLocation =findViewById(R.id.txt_docLocation_apo);
        txt_e_t1 = findViewById(R.id.txt_e_t1);
        txt_e_t2 = findViewById(R.id.txt_e_t2);
        txt_e_t3 = findViewById(R.id.txt_e_t3);
        txt_e_t4 = findViewById(R.id.txt_e_t4);
        txt_m_t1 = findViewById(R.id.txt_m_t1);
        txt_m_t2 = findViewById(R.id.txt_m_t2);
        txt_m_t3 = findViewById(R.id.txt_m_t3);
    }



}