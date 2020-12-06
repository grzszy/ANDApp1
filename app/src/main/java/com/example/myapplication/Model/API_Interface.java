package com.example.myapplication.Model;


import retrofit2.Call;
import retrofit2.http.GET;

public interface API_Interface {

    @GET("ques.json")
    Call<API_Response> getQuestion(String que, String a, String b, String c, String d, int id);
}
