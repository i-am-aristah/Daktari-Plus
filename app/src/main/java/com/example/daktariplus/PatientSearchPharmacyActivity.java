package com.example.daktariplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;

import com.example.daktariplus.adapters.AllMedicinesAdapter;
import com.example.daktariplus.model.MedicineModel;
import com.example.daktariplus.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PatientSearchPharmacyActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView img_back;
    SearchView searchView;
    RecyclerView rcv;
    LinearLayoutManager layoutManager;
    AllMedicinesAdapter adapter;
    List<MedicineModel> medList;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_search_pharmacy);

        img_back = findViewById(R.id.img_back_medi);
        searchView = findViewById(R.id.med_search_view);
        rcv = findViewById(R.id.rcv_med_search_list);
        img_back.setOnClickListener(this);

        rcv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rcv.setLayoutManager(layoutManager);


        Call<List<MedicineModel>> c = ApiClient.getApiService().getAllMedicine();

        c.enqueue(new Callback<List<MedicineModel>>() {
            @Override
            public void onResponse(Call<List<MedicineModel>> call, Response<List<MedicineModel>> response) {
                medList = response.body();
                adapter = new AllMedicinesAdapter(getApplicationContext(),medList);
                rcv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<MedicineModel>> call, Throwable t) {

            }
        });






    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.img_back_medi:
                startActivity(new Intent(getApplicationContext(),PatientHomeActivity.class));
                break;
        }
    }
}