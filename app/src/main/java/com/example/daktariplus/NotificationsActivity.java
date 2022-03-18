package com.example.daktariplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.daktariplus.adapters.NotificationAdapter;
import com.example.daktariplus.model.NotificationModel;
import com.example.daktariplus.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationsActivity extends AppCompatActivity {

    RecyclerView rcv;
    NotificationAdapter adapter;
    List<NotificationModel> dataList;
    LinearLayoutManager layoutManager;
    ImageView img_back_noti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        img_back_noti = findViewById(R.id.img_back_noti);
        rcv = findViewById(R.id.rcv_notifications);
        rcv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rcv.setLayoutManager(layoutManager);


        Call<List<NotificationModel>> call = ApiClient.getApiService().getNotifications();
        call.enqueue(new Callback<List<NotificationModel>>() {
            @Override
            public void onResponse(Call<List<NotificationModel>> call, Response<List<NotificationModel>> response) {
                dataList = response.body();
                adapter = new NotificationAdapter(getApplicationContext(),dataList);
                rcv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<NotificationModel>> call, Throwable t) {

            }
        });

        img_back_noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),PatientHomeActivity.class));
            }
        });
    }
}