package com.example.daktariplus.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.daktariplus.R;
import com.example.daktariplus.model.Doctor;

import java.util.List;

public class AllDoctorsAdapter extends RecyclerView.Adapter<AllDoctorsAdapter.MyViewHolder> {

    Context context;
    List<Doctor> doctorList;


    public AllDoctorsAdapter(Context context, List<Doctor> doctor) {
        this.context = context;
        this.doctorList = doctor;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.all_doctors_row_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Doctor doctor = doctorList.get(position);
        holder.txt_docs_name.setText(doctor.getDoc_name());
        holder.txt_docs_experience.setText(doctor.getLocation());


        //String image_url = "http://10.0.2.2:8000/"+doctor.getImage();
        String image_url = "http://10.0.2.2/daktariplus/public/"+doctor.getImage();
        //String image_url = "http://192.168.43.155/daktariplus/public/"+doctor.getImage();


        Glide.with(context)
                .load(image_url)
                .placeholder(R.drawable.load)
                .into(holder.img_docs_prof);


    }

    @Override
    public int getItemCount() {
        return doctorList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView img_docs_prof;
        TextView txt_docs_name,txt_docs_experience;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img_docs_prof = itemView.findViewById(R.id.img_docs_prof);
            txt_docs_name = itemView.findViewById(R.id.txt_docs_name);
            txt_docs_experience = itemView.findViewById(R.id.txt_docs_experience);


        }
    }
}
