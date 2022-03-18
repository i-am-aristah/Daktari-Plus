package com.example.daktariplus.fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.daktariplus.R;
import com.example.daktariplus.adapters.AppointmentAdapter;
import com.example.daktariplus.model.AppointmentModel;
import com.example.daktariplus.model.MedicalRecordModel;
import com.example.daktariplus.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MyAppointmentsFragment extends Fragment {

RecyclerView rcv;
List<AppointmentModel> dataList;
AppointmentAdapter adapter;
LinearLayoutManager layoutManager;
ImageView img_no_available_appointments;
String SHAREPREFFILE;
    public MyAppointmentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vv = inflater.inflate(R.layout.fragment_my_appointments, container, false);
        rcv = vv.findViewById(R.id.rcv_my_appointments);
        img_no_available_appointments =vv.findViewById(R.id.img_no_available_appointments);
        rcv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(vv.getContext());
        rcv.setLayoutManager(layoutManager);

        //stored in SharedPreferencces or Room DB
        String patient_id=null;
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHAREPREFFILE,MODE_PRIVATE);
        patient_id = sharedPreferences.getString("user_id",patient_id);
        patient_id = "1";

        Call<List<AppointmentModel>> call = ApiClient.getApiService().getAppointmentRecord(patient_id);

        call.enqueue(new Callback<List<AppointmentModel>>() {
            @Override
            public void onResponse(Call<List<AppointmentModel>> call, Response<List<AppointmentModel>> response) {

                dataList = response.body();
                if(dataList.size()==0)
                {
                    img_no_available_appointments.setVisibility(View.VISIBLE);
                    rcv.setVisibility(View.GONE);
                }
                else {
                    adapter = new AppointmentAdapter(getContext(), dataList);
                    rcv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<AppointmentModel>> call, Throwable t) {

            }
        });

        return vv;
    }
}