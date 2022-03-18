package com.example.daktariplus.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daktariplus.R;
import com.example.daktariplus.model.AppointmentModel;
import com.example.daktariplus.model.MedicalRecordModel;

import java.util.List;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.MyViewHolder> {

    Context mcxt;
    List<AppointmentModel> dataList;

    public AppointmentAdapter(Context mcxt, List<AppointmentModel> dataList) {
        this.mcxt = mcxt;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mcxt).inflate(R.layout.my_appointments_row_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AppointmentModel data = dataList.get(position);

        //holder.txt_appo_id.setText(data.getAppointment_id());
        //holder.txt_appo_id.setText(data.getAppointment_id());
        holder.txt_doc_name_appoi.setText(data.getDoctor_name());
        holder.txt_time_appoi.setText(data.getAppointment_time());
        //holder.txt_status_appoi.setText(data.getAppointment_status());


        holder.img_reasons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcxt.getApplicationContext(),"The Doctor is Currently Engaged, Make Another Booking",Toast.LENGTH_LONG).show();
            }
        });



        if(data.getAppointment_status().equals("0"))
        {
            holder.txt_status_appoi.setText("Pending");
            holder.txt_status_appoi.setBackgroundColor(Color.BLUE);
            holder.img_reasons.setVisibility(View.GONE);

        }
        if(data.getAppointment_status().equals("1"))
        {
            holder.txt_status_appoi.setText("Accepted");
            holder.txt_status_appoi.setBackgroundColor(Color.GREEN);
            holder.img_reasons.setVisibility(View.GONE);
        }
        if(data.getAppointment_status().equals("2"))
        {
            holder.txt_status_appoi.setText("Rejected");
            holder.txt_status_appoi.setBackgroundColor(Color.RED);
        }
        if(data.getAppointment_status().equals("3"))
        {
            holder.txt_status_appoi.setText("Lapsed");
            holder.txt_status_appoi.setBackgroundColor(Color.MAGENTA);
            holder.img_reasons.setVisibility(View.GONE);
        }



    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img_reasons;

        TextView txt_appo_id,txt_doc_name_appoi,txt_time_appoi,txt_status_appoi;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_appo_id = itemView.findViewById(R.id.txt_appo_id);
            txt_doc_name_appoi =itemView.findViewById(R.id.txt_doc_name_appoi);
            txt_time_appoi = itemView.findViewById(R.id.txt_time_appoi);
            txt_status_appoi = itemView.findViewById(R.id.txt_status_appoi);
            img_reasons = itemView.findViewById(R.id.img_reasons);
        }
    }
}
