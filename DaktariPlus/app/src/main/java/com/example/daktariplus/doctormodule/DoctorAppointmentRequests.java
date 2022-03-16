package com.example.daktariplus.doctormodule;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daktariplus.R;
import com.example.daktariplus.adapters.DoctorAppointmentsRequestAdapter;
import com.example.daktariplus.model.AppointmentModel;
import com.example.daktariplus.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DoctorAppointmentRequests extends Fragment {

RecyclerView rcv_doc_appo_req;
LinearLayoutManager layoutManager;
DoctorAppointmentsRequestAdapter adapter;
List<AppointmentModel> dataList;
TextView txt_no_r_a;

    public DoctorAppointmentRequests() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_doctor_appointment_requests, container, false);

        rcv_doc_appo_req = view.findViewById(R.id.rcv_doc_appo_req);
        txt_no_r_a = view.findViewById(R.id.txt_no_r_a);
        rcv_doc_appo_req.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(view.getContext());
        rcv_doc_appo_req.setLayoutManager(layoutManager);

       Call<List<AppointmentModel>> call = ApiClient.getApiService().getDocAppointmentRecord("Otedo peter");
       call.enqueue(new Callback<List<AppointmentModel>>() {
           @Override
           public void onResponse(Call<List<AppointmentModel>> call, Response<List<AppointmentModel>> response) {

               dataList = response.body();


               List<AppointmentModel> filteredData;
               if(dataList.size()>=1)
               {

                   adapter = new DoctorAppointmentsRequestAdapter(getContext(),dataList);
                   rcv_doc_appo_req.setAdapter(adapter);
               }
                 else
               {
                   rcv_doc_appo_req.setVisibility(View.GONE);
                   txt_no_r_a.setVisibility(View.VISIBLE);
               }


           }

           @Override
           public void onFailure(Call<List<AppointmentModel>> call, Throwable t) {

           }
       });
        return  view;
    }
}