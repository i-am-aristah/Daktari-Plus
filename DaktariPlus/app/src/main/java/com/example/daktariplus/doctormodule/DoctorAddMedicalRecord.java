package com.example.daktariplus.doctormodule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.daktariplus.R;
import com.example.daktariplus.fragments.MedicalRecordsFragment;
import com.example.daktariplus.model.MedicalRecordModel;
import com.example.daktariplus.network.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;


public class DoctorAddMedicalRecord extends Fragment {
    EditText edtxt_patient_id,edtxt_patient_condition,edtxt_patient_fee_charged;
    Button btn_add_med_Rec;



    public DoctorAddMedicalRecord() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_doctor_add_medical_record, container, false);
        edtxt_patient_id = view.findViewById(R.id.edtxt_patient_id);
        edtxt_patient_condition = view.findViewById(R.id.edtxt_patient_condition);
        edtxt_patient_fee_charged = view.findViewById(R.id.edtxt_patient_fee_charged);
        btn_add_med_Rec = view.findViewById(R.id.btn_add_med_Rec);


        btn_add_med_Rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String treatment_date ="29/09/2021";
                String  hospital_name ="Maseno Hospital";
                String patient_id = edtxt_patient_id.getText().toString();
                String fee_charged =edtxt_patient_fee_charged.getText().toString();
                String medical_condition =edtxt_patient_condition.getText().toString();
                String doctor_id ="1";

                Call<MedicalRecordModel> cll = ApiClient.getApiService().addMedicalRecord(treatment_date,
                        hospital_name,patient_id,fee_charged,medical_condition,doctor_id);

                cll.enqueue(new Callback<MedicalRecordModel>() {
                    @Override
                    public void onResponse(Call<MedicalRecordModel> call, Response<MedicalRecordModel> response) {

                        if(response.isSuccessful())
                        {
                            Toast.makeText(getContext(), "Medical Record Inserted Successfully", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<MedicalRecordModel> call, Throwable t) {

                        Toast.makeText(getContext(), "Failed to Add Medical Record", Toast.LENGTH_LONG).show();

                    }
                });
            }
        });




        return view;
    }
}
