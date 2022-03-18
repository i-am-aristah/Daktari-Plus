package com.example.daktariplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.daktariplus.network.ApiClient;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PatientProfileActivity extends AppCompatActivity {

    ImageView img_back;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String SHAREPREFFILE;
    TextInputEditText edtx_full_name,edtx_full_email,edtx_full_area,edtx_full_county,edtx_full_phone;
    Button btn_udate_profile;




    TextView full_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);

//        editor.putString("user_id",user_id);
//        editor.putString("username",user_name);
//        editor.putBoolean("login_status",true);
//        editor.putString("token",token);
//        editor.putString("email",email);

        full_name = findViewById(R.id.full_name);
        edtx_full_name= findViewById(R.id.edtx_full_name);
        edtx_full_email = findViewById(R.id.edtx_full_email);
        edtx_full_area = findViewById(R.id.edtx_full_area);
        edtx_full_county = findViewById(R.id.edtx_full_county);
        edtx_full_phone = findViewById(R.id.edtx_full_phone);
        btn_udate_profile=findViewById(R.id.btn_udate_profile);

        preferences =getSharedPreferences(SHAREPREFFILE,0);



        full_name.setText(preferences.getString("username","Username"));
        edtx_full_name.setText(preferences.getString("username","Username"));
        edtx_full_email.setText(preferences.getString("email","user@email.com"));
       edtx_full_area.setText(preferences.getString("area","Maseno"));
       edtx_full_county.setText(preferences.getString("county","Kisumu"));
       edtx_full_phone.setText(preferences.getString("phone","+254"));



       Call<Response> call = ApiClient.getApiService().getdetail();
       call.enqueue(new Callback<Response>() {
           @Override
           public void onResponse(Call<Response> call, Response<Response> response) {

               Response arrayList = response.body();
           }

           @Override
           public void onFailure(Call<Response> call, Throwable t) {

           }
       });




    }


}