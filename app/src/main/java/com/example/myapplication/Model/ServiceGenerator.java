package com.example.myapplication.Model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {


    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://opentdb.com/api.php?amount=10&category=18&difficulty=easy&type=multiple&encode=base64")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();
    private static API_Interface api_interface = retrofit.create(API_Interface.class);


    public static API_Interface getAPI_interface() {
        return api_interface;
    }
}

