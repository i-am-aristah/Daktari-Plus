package com.example.daktariplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daktariplus.adapters.DoctorAdapter;
import com.example.daktariplus.model.Doctor;
import com.example.daktariplus.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpecialistActivity extends AppCompatActivity {

    RecyclerView rcv;
    List<Doctor> doctorList;
    DoctorAdapter adapter;
    LinearLayoutManager layoutManager;
    TextView txt_no_rec_found_s;
    ImageView img_not_found_s;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialist);

        rcv = findViewById(R.id.rcv_doctor);
        img_not_found_s = findViewById(R.id.img_not_found_s);
        txt_no_rec_found_s =findViewById(R.id.txt_no_rec_found_s);

        rcv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rcv.setLayoutManager(layoutManager);



        Bundle bundle = getIntent().getExtras();
        assert bundle != null;

       String speciality_name = bundle.getString("name");

        Toast.makeText(getApplicationContext(), speciality_name, Toast.LENGTH_SHORT).show();


        //Call<List<Doctor>> call = ApiClient.getApiService().getDoctors(speciality_name);

       Call<List<Doctor>> call = ApiClient.getApiService().getDoctors(speciality_name);
        call.enqueue(new Callback<List<Doctor>>() {
            @Override
            public void onResponse(Call<List<Doctor>> call, Response<List<Doctor>> response) {
                doctorList =response.body();

                if(doctorList.size()>=1) {
                    adapter = new DoctorAdapter(getApplicationContext(), doctorList);
                    rcv.setAdapter(adapter);
                }
                else
                {
                    rcv.setVisibility(View.GONE);
                    txt_no_rec_found_s.setVisibility(View.VISIBLE);
                    img_not_found_s.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Doctor>> call, Throwable t) {

                Toast.makeText(getApplication(),"Something Went Wrong",Toast.LENGTH_LONG).show();

            }
        });


    }
}