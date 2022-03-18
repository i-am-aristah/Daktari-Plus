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
import com.example.daktariplus.model.NotificationModel;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    Context mcxt;
    List<NotificationModel> dataList;

    public NotificationAdapter(Context mcxt, List<NotificationModel> dataList) {
        this.mcxt = mcxt;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mcxt).inflate(R.layout.notification_row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        NotificationModel data = dataList.get(position);
        holder.noti_details.setText(data.getDetails());
        holder.noti_region.setText(data.getRegion());
        holder.noti_author.setText(data.getAuthor());
        holder.noti_views.setText(data.getViews());

       // String image_url ="http://10.0.2.2:8000/"+data.getImage();

        String image_url ="http://10.0.2.2/daktariplus/public/"+data.getImage();
        //String image_url = "http://192.168.43.155/daktariplus/public/"+data.getImage();


        Glide.with(mcxt)
                .load(image_url)
                .placeholder(R.drawable.load)
                .into(holder.imgNotification);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder{
        ImageView imgNotification;
        TextView noti_details, noti_region, noti_author, noti_views;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgNotification = itemView.findViewById(R.id.img_noti_image);
            noti_details = itemView.findViewById(R.id.txt_noti_detail);
            noti_region=itemView.findViewById(R.id.txt_noti_region);
            noti_author = itemView.findViewById(R.id.txt_noti_author);
            noti_views = itemView.findViewById(R.id.txt_views);

        }
    }
}
