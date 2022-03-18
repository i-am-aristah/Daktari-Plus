package com.example.daktariplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.daktariplus.adapters.AllDoctorsAdapter;
import com.example.daktariplus.model.Doctor;
import com.example.daktariplus.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllDoctorsActivity extends AppCompatActivity {

    List<Doctor> doctorList;
    RecyclerView rcv;
    AllDoctorsAdapter adapter;
    LinearLayoutManager layoutManager;
    ImageView img_back_doct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_doctors);
        img_back_doct = findViewById(R.id.img_back_doct);
        rcv = findViewById(R.id.rcv_all_doct);
        rcv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rcv.setLayoutManager(layoutManager);



        img_back_doct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),PatientHomeActivity.class));
            }
        });

        Call<List<Doctor>> call = ApiClient.getApiService().getAllDoctors();
        call.enqueue(new Callback<List<Doctor>>() {
            @Override
            public void onResponse(Call<List<Doctor>> call, Response<List<Doctor>> response) {

                doctorList = response.body();

                adapter= new AllDoctorsAdapter(getApplication(),doctorList);
                rcv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Doctor>> call, Throwable t) {

            }
        });

    }
}