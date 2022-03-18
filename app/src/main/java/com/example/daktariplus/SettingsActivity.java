package com.example.daktariplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView img_back;
    LinearLayout ll_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        img_back = findViewById(R.id.img_back_sett);
        ll_profile = findViewById(R.id.ll_profile);


        img_back.setOnClickListener(this);
        ll_profile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.img_back_sett:
                startActivity(new Intent(getApplicationContext(),PatientHomeActivity.class));
                break;
            case R.id.ll_profile:
                //startActivity(new Intent(getApplicationContext(),PatientProfileActivity.class));
                break;
        }
    }
}