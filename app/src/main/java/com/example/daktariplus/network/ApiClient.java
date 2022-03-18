package com.example.daktariplus.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    //private  static String BASE_URL ="http://10.0.2.2:8000/api/daktariplus/";
     private  static String BASE_URL ="http://10.0.2.2/daktariplus/api/daktariplus/";
    //private  static String BASE_URL ="http://192.168.43.155/daktariplus/api/daktariplus/";


    private static Retrofit retrofit;



    public static Retrofit getApiClient()
    {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        if(retrofit==null)
        {
            retrofit= new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

    public static ApiService getApiService()
    {

        return  getApiClient().create(ApiService.class);
    }
}
