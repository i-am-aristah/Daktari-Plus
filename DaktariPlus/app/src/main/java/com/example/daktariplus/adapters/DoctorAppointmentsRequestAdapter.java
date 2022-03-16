package com.example.daktariplus.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daktariplus.R;
import com.example.daktariplus.model.AppointmentModel;
import com.example.daktariplus.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class DoctorAppointmentsRequestAdapter extends RecyclerView.Adapter<DoctorAppointmentsRequestAdapter.MyViewHolder> {


    Context mctxt;
    List<AppointmentModel> dataList;

    public DoctorAppointmentsRequestAdapter(Context mctxt, List<AppointmentModel> dataList) {
        this.mctxt = mctxt;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mctxt).inflate(R.layout.doc_appointment_request_row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        AppointmentModel doctorAppoReq = dataList.get(position);

        holder.txt_doc_appo_patient_name.setText(doctorAppoReq.getPatient_name());
        holder.txt_doc_appo_patient_med_cond.setText(doctorAppoReq.getDoctor_name());
        holder.txt_doc_appo_time.setText(doctorAppoReq.getAppointment_time());

        holder.btn_appo_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String appointment_status= "1";
                int id = doctorAppoReq.getAppointment_id();



             Call<AppointmentModel> call = ApiClient.getApiService().updateAppointment(id,appointment_status);
             call.enqueue(new Callback<AppointmentModel>() {
                 @Override
                 public void onResponse(Call<AppointmentModel> call, Response<AppointmentModel> response) {

                     Toast.makeText(mctxt, "Record Updates Successfully"+id, Toast.LENGTH_SHORT).show();
                    if (response.isSuccessful())
                    {
                        holder.cv_a_r_h.setVisibility(View.GONE);
                    }
                 }

                 @Override
                 public void onFailure(Call<AppointmentModel> call, Throwable t) {

                     Toast.makeText(mctxt, "Record Failed", Toast.LENGTH_SHORT).show();


                 }
             });

            }
        });

        holder.btn_appo_reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String appointment_status= "2";
                int id = doctorAppoReq.getAppointment_id();



                Call<AppointmentModel> call = ApiClient.getApiService().updateAppointment(id,appointment_status);
                call.enqueue(new Callback<AppointmentModel>() {
                    @Override
                    public void onResponse(Call<AppointmentModel> call, Response<AppointmentModel> response) {

                        Toast.makeText(mctxt, "Record Updates Successfully"+id, Toast.LENGTH_SHORT).show();
                        if (response.isSuccessful())
                        {
                            holder.cv_a_r_h.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onFailure(Call<AppointmentModel> call, Throwable t) {

                        Toast.makeText(mctxt, "Record Failed", Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });

        holder.btn_appo_lapsed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String appointment_status= "3";
                int id = doctorAppoReq.getAppointment_id();



                Call<AppointmentModel> call = ApiClient.getApiService().updateAppointment(id,appointment_status);
                call.enqueue(new Callback<AppointmentModel>() {
                    @Override
                    public void onResponse(Call<AppointmentModel> call, Response<AppointmentModel> response) {

                        Toast.makeText(mctxt, "Record Updates Successfully"+id, Toast.LENGTH_SHORT).show();
                        if (response.isSuccessful())
                        {
                            holder.cv_a_r_h.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onFailure(Call<AppointmentModel> call, Throwable t) {

                        Toast.makeText(mctxt, "Record Failed", Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_doc_appo_patient_name,txt_doc_appo_patient_med_cond,txt_doc_appo_time;
        Button btn_appo_accept,btn_appo_reject,btn_appo_lapsed;
        CardView cv_a_r_h;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            btn_appo_accept = itemView.findViewById(R.id.btn_appo_accept);
            btn_appo_reject = itemView.findViewById(R.id.btn_appo_reject);
            btn_appo_lapsed = itemView.findViewById(R.id.btn_appo_lapsed);

            txt_doc_appo_patient_name = itemView.findViewById(R.id.txt_doc_appo_patient_name);
            txt_doc_appo_patient_med_cond = itemView.findViewById(R.id.txt_doc_appo_patient_med_cond);
            txt_doc_appo_time = itemView.findViewById(R.id.txt_doc_appo_time);
            cv_a_r_h = itemView.findViewById(R.id.cv_a_r_h);



        }
    }
}
