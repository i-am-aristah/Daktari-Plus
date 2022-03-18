package com.example.daktariplus.doctormodule;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daktariplus.R;
import com.example.daktariplus.adapters.DoctorAppointmentHistoryAdapter;
import com.example.daktariplus.model.AppointmentModel;
import com.example.daktariplus.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorAppointmentHistory extends Fragment {

    RecyclerView rcv_doc_appo_hist;
    DoctorAppointmentHistoryAdapter adapter;
    List<AppointmentModel> dataList;
    LinearLayoutManager layoutManager;



    public DoctorAppointmentHistory() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.fragment_doctor_appointment_history, container, false);

        rcv_doc_appo_hist = view.findViewById(R.id.rcv_doc_appo_hist);
        rcv_doc_appo_hist.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(view.getContext());
        rcv_doc_appo_hist.setLayoutManager(layoutManager);

        Call<List<AppointmentModel>> call = ApiClient.getApiService().getDocAppointmentHistory("Otedo peter");

        call.enqueue(new Callback<List<AppointmentModel>>() {
            @Override
            public void onResponse(Call<List<AppointmentModel>> call, Response<List<AppointmentModel>> response) {

                dataList = response.body();

                adapter = new DoctorAppointmentHistoryAdapter(getContext(),dataList);
                rcv_doc_appo_hist.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<AppointmentModel>> call, Throwable t) {

            }
        });



        return view;
    }
}