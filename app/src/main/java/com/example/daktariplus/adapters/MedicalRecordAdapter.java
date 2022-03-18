package com.example.daktariplus.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daktariplus.R;
import com.example.daktariplus.model.MedicalRecordModel;

import java.util.List;

public class MedicalRecordAdapter extends RecyclerView.Adapter<MedicalRecordAdapter.MyViewHolder> {

    Context mcxt;
    List<MedicalRecordModel> medicalRecord;

    public MedicalRecordAdapter(Context mcxt, List<MedicalRecordModel> medicalRecord) {
        this.mcxt = mcxt;
        this.medicalRecord = medicalRecord;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mcxt).inflate(R.layout.medical_record_row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        MedicalRecordModel data = medicalRecord.get(position);
        holder.txt_med_rec_date.setText(data.getTreatment_date());
        holder.txt_med_rec_hospitalName.setText(data.getHospital_name());
        holder.txt_med_condition.setText(data.getMedical_condition());
        holder.txt_fee_charged.setText(data.getFee_charged());

    }

    @Override
    public int getItemCount() {
        return medicalRecord.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_med_rec_date,txt_med_rec_hospitalName,txt_med_condition,txt_fee_charged;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_med_rec_date = itemView.findViewById(R.id.txt_med_rec_date);
            txt_med_rec_hospitalName =itemView.findViewById(R.id.txt_med_rec_hospitalName);
            txt_med_condition = itemView.findViewById(R.id.txt_med_condition);
            txt_fee_charged = itemView.findViewById(R.id.txt_fee_charged);
        }
    }
}
