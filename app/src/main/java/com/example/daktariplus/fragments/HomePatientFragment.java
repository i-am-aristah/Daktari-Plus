package com.example.daktariplus.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daktariplus.R;
import com.example.daktariplus.adapters.SpecialistAdapter;
import com.example.daktariplus.model.Specialist;
import com.example.daktariplus.network.ApiClient;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomePatientFragment extends Fragment {
    RecyclerView rcv;
    GridLayoutManager layoutManager;
    SpecialistAdapter adapter;
    List<Specialist> dataList;
    private ShimmerFrameLayout mFrameLayout;

    public HomePatientFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_patient, container, false);

        rcv = view.findViewById(R.id.rcv_specialist);
        layoutManager= new GridLayoutManager(view.getContext(),3);
        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(layoutManager);
        mFrameLayout = view.findViewById(R.id.shimmerLayout);


        Call<List<Specialist>> call = ApiClient.getApiService().getSpecialist();

        call.enqueue(new Callback<List<Specialist>>() {
            @Override
            public void onResponse(Call<List<Specialist>> call, Response<List<Specialist>> response) {

                dataList = response.body();

                adapter = new SpecialistAdapter(view.getContext(),dataList);
                rcv.setAdapter(adapter);
                mFrameLayout.startShimmer();
                mFrameLayout.setVisibility(View.GONE);
                rcv.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<List<Specialist>> call, Throwable t) {

            }
        });



        return view;
    }
}