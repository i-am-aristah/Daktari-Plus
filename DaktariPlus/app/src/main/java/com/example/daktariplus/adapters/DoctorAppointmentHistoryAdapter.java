package com.example.daktariplus.adapters;

import static android.graphics.Color.*;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daktariplus.R;
import com.example.daktariplus.model.AppointmentModel;

import java.util.List;

public class DoctorAppointmentHistoryAdapter extends RecyclerView.Adapter<DoctorAppointmentHistoryAdapter.MyViewHolder> {

    Context mctxt;
    List<AppointmentModel> dataList;

    public DoctorAppointmentHistoryAdapter(Context mctxt, List<AppointmentModel> dataList) {
        this.mctxt = mctxt;
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mctxt).inflate(R.layout.doc_appoi_history_row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        AppointmentModel data = dataList.get(position);

        if(data.getAppointment_status().equals("1"))
        {
            holder.txt_doc_appo_patient_status.setBackgroundColor(GREEN);
            holder.txt_doc_appo_patient_status.setText("Accepted");
            holder.txt_doc_appo_patient_status.setTextColor(WHITE);
        }

        if(data.getAppointment_status().equals("2"))
        {
            holder.txt_doc_appo_patient_status.setBackgroundColor(RED);
            holder.txt_doc_appo_patient_status.setText("Rejected");
            holder.txt_doc_appo_patient_status.setTextColor(WHITE);
        }
        if(data.getAppointment_status().equals("3"))
        {
            holder.txt_doc_appo_patient_status.setBackgroundColor(GRAY);
            holder.txt_doc_appo_patient_status.setText("Lapsed");
            holder.txt_doc_appo_patient_status.setTextColor(WHITE);
        }



        holder.txt_doc_appo_patient_his_name.setText(data.getPatient_name());
        holder.txt_doc_appo_patient_his_time.setText(data.getAppointment_time());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_doc_appo_patient_his_name,txt_doc_appo_patient_his_time,txt_doc_appo_patient_status;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_doc_appo_patient_his_name = itemView.findViewById(R.id.txt_doc_appo_patient_his_name);
            txt_doc_appo_patient_his_time = itemView.findViewById(R.id.txt_doc_appo_patient_his_time);
            txt_doc_appo_patient_status = itemView.findViewById(R.id.txt_doc_appo_patient_status);

        }
    }
}
