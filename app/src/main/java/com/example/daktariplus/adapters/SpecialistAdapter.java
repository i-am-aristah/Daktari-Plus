package com.example.daktariplus.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.daktariplus.R;
import com.example.daktariplus.SpecialistActivity;
import com.example.daktariplus.model.Specialist;

import java.util.ArrayList;
import java.util.List;

public class SpecialistAdapter extends RecyclerView.Adapter<SpecialistAdapter.MyViewHolder> {

    Context mctx;
    List<Specialist> dataList;

    public SpecialistAdapter(Context mctx, List<Specialist> dataList) {
        this.mctx = mctx;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mctx).inflate(R.layout.specialist_row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Specialist specialist = dataList.get(position);

        holder.speciality_name.setText(specialist.getSpeciality_name());

        //String image_url="http://10.0.2.2:8000/"+specialist.getSpeciality_image();
        String image_url="http://10.0.2.2/daktariplus/public/"+specialist.getSpeciality_image();
        //String image_url = "http://192.168.43.155/daktariplus/public/"+specialist.getSpeciality_image();



        Glide.with(mctx)
                .load(image_url)
                .placeholder(R.drawable.load)
                .into(holder.image_url);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String speciality = specialist.getSpeciality_name();

                Intent intent = new Intent(mctx.getApplicationContext(), SpecialistActivity.class);
                intent.putExtra("name", speciality);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mctx.getApplicationContext().startActivity(intent);
               // view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image_url;
        TextView  speciality_name;
        LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image_url = itemView.findViewById(R.id.img_specialist_image);
            speciality_name = itemView.findViewById(R.id.txtv_specialist_name);
            linearLayout = itemView.findViewById(R.id.ll_specialist);
        }
    }
}
