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
import com.example.daktariplus.adapters.MedicalRecordAdapter;
import com.example.daktariplus.model.MedicalRecordModel;
import com.example.daktariplus.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MedicalRecordsFragment extends Fragment {

    RecyclerView rcv;
    LinearLayoutManager layoutManager;
    List<MedicalRecordModel> dataList;
    MedicalRecordAdapter adapter;
    ImageView img_no_available_med_rec;
    String SHAREPREFFILE;

    public MedicalRecordsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_medical_records, container, false);
        rcv = view.findViewById(R.id.rcv_med_rec);
        img_no_available_med_rec = view.findViewById(R.id.img_no_available_med_rec);

        rcv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(view.getContext());
        rcv.setLayoutManager(layoutManager);


        String patient_id;


        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHAREPREFFILE,MODE_PRIVATE);
         //patient_id = sharedPreferences.getString("user_id","user");
          patient_id = "1";




        Call<List<MedicalRecordModel>>  call = ApiClient.getApiService().getPatientMedicalRecords(patient_id);
        call.enqueue(new Callback<List<MedicalRecordModel>>() {
            @Override
            public void onResponse(Call<List<MedicalRecordModel>> call, Response<List<MedicalRecordModel>> response) {
                dataList = response.body();

                if(dataList.size()==0)
                {
                    rcv.setVisibility(View.GONE);
                    img_no_available_med_rec.setVisibility(View.VISIBLE);
                }
                else {
                    adapter = new MedicalRecordAdapter(getContext(), dataList);
                    rcv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<MedicalRecordModel>> call, Throwable t) {

            }
        });

        return view;
    }

}