package com.example.daktariplus.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.daktariplus.BookingAppointmentTimeSlot;
import com.example.daktariplus.R;
import com.example.daktariplus.model.Doctor;

import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.MyViewHolder> {

    Context mctx;
    List<Doctor> doctorList;

    public DoctorAdapter(Context mctx, List<Doctor> doctorList) {
        this.mctx = mctx;
        this.doctorList = doctorList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mctx).inflate(R.layout.doctor_row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Doctor doctor = doctorList.get(position);
        holder.doc_name.setText(doctor.getDoc_name());
        holder.hos_name.setText(doctor.getHospital_name());
        holder.location.setText(doctor.getLocation());
        holder.fee.setText(doctor.getFee());

        //String image_url = "http://10.0.2.2:8000/"+doctor.getImage();
        String image_url = "http://10.0.2.2/daktariplus/public/"+doctor.getImage();

        //String image_url = "http://192.168.43.155/daktariplus/public/"+doctor.getImage();


        Glide.with(mctx)
                .load(image_url)
                .placeholder(R.drawable.load)
                .into(holder.img_doctor);


        holder.btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mctx.getApplicationContext(), BookingAppointmentTimeSlot.class);
                intent.putExtra("doc_name",doctor.getDoc_name());
                intent.putExtra("doc_location",doctor.getLocation());
                intent.putExtra("doc_image", image_url);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mctx.getApplicationContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return doctorList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView img_doctor;
        TextView doc_name, hos_name,location, fee;
        Button btn_book;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img_doctor = itemView.findViewById(R.id.img_doctor);
            doc_name =itemView.findViewById(R.id.txt_doc_name);
            hos_name = itemView.findViewById(R.id.txt_hos_name);
            location = itemView.findViewById(R.id.txt_location);
            fee = itemView.findViewById(R.id.txt_fee);
            btn_book= itemView.findViewById(R.id.btn_book_doc);

        }
    }
}
