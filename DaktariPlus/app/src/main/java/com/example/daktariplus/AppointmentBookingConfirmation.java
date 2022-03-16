package com.example.daktariplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AppointmentBookingConfirmation extends AppCompatActivity {

    ImageView img_close_appo_bk_conf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_booking_confirmation);

        img_close_appo_bk_conf = findViewById(R.id.img_close_appo_bk_conf);

        img_close_appo_bk_conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),PatientHomeActivity.class));
            }
        });
    }
}