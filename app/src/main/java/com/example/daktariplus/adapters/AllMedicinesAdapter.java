package com.example.daktariplus.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.daktariplus.R;
import com.example.daktariplus.SpecificMedicineActivity;
import com.example.daktariplus.model.MedicineModel;

import java.util.List;

public class AllMedicinesAdapter extends RecyclerView.Adapter<AllMedicinesAdapter.MyViewHolder> {

    Context context;
    List<MedicineModel> medList;

    public AllMedicinesAdapter(Context context, List<MedicineModel> medList) {
        this.context = context;
        this.medList = medList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.medicine_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        MedicineModel med = medList.get(position);

        holder.txt_med_name.setText(med.getMed_name());

        //String image_url = "http://10.0.2.2:8000/"+med.getMed_image();
        String image_url = "http://10.0.2.2/daktariplus/"+med.getMed_image();
        //String image_url = "http://192.168.43.155/daktariplus/public/"+med.getMed_image();

        Glide.with(context)
                .load(image_url)
                .placeholder(R.drawable.load)
                .into(holder.img_med_image);


        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent md = new Intent(context.getApplicationContext(), SpecificMedicineActivity.class);
                md.putExtra("medicineName",med.getMed_name());
                md.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.getApplicationContext().startActivity(md);
            }
        });
    }

    @Override
    public int getItemCount() {
        return medList.size();
    }

    public class MyViewHolder  extends  RecyclerView.ViewHolder{
        ImageView img_med_image;
        TextView txt_med_name;
        LinearLayout ll;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img_med_image = itemView.findViewById(R.id.img_med_image);
            txt_med_name = itemView.findViewById(R.id.txt_med_name);
            ll= itemView.findViewById(R.id.ll_med_sele);
        }
    }
}
