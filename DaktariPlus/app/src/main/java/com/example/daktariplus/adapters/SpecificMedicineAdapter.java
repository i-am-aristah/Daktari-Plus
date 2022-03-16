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
import com.example.daktariplus.model.SpecificMedicine;

import java.util.List;

public class SpecificMedicineAdapter extends RecyclerView.Adapter<SpecificMedicineAdapter.MyViewHolder> {

    Context mctx;
    List<SpecificMedicine> medData;

    public SpecificMedicineAdapter(Context mctx, List<SpecificMedicine> medData) {
        this.mctx = mctx;
        this.medData = medData;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mctx).inflate(R.layout.specific_medicine_row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        SpecificMedicine data = medData.get(position);

        holder.txt_med_name_med.setText(data.getMedicine_name());
        holder.txt_pharm_name_med.setText(data.getPharmacy_name());
        holder.txt_coun_phar_med.setText(data.getMed_county());
        holder.txt_phar_area_med.setText(data.getMed_location());

        //String image_url = "http://10.0.0.2:8080/"+data.getMed_pic();
        String image_url = "http://10.0.0.2/daktariplus/public/"+data.getMed_pic();
        //String image_url = "http://192.168.43.155/daktariplus/public/"+data.getMed_pic();

        Glide.with(mctx)
                .load(image_url)
                .placeholder(R.drawable.med_bg)
                .into(holder.img_med_pic_med);


    }

    @Override
    public int getItemCount() {
        return medData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_med_pic_med;
        TextView txt_med_name_med,txt_pharm_name_med,txt_coun_phar_med,txt_phar_area_med;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_med_pic_med = itemView.findViewById(R.id.img_med_pic_med);
            txt_med_name_med = itemView.findViewById(R.id.txt_med_name_med);
            txt_pharm_name_med =itemView.findViewById(R.id.txt_pharm_name_med);
            txt_coun_phar_med = itemView.findViewById(R.id.txt_coun_phar_med);
            txt_phar_area_med =itemView.findViewById(R.id.txt_phar_area_med);
        }
    }
}