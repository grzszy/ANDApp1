package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class API_Response {

    @SerializedName("ques")
    @Expose
    private String que;
    @SerializedName("answerA")
    @Expose
    private String a;
    @SerializedName("answerB")
    @Expose
    private String b;
    @SerializedName("answerC")
    @Expose
    private String c;
    @SerializedName("answerD")
    @Expose
    private String d;
    @SerializedName("answerA")
    @Expose
    private int id;

    public Question getQuestion()
    {
        return new Question(que,a,b,c,d,id);
    }



    private class Answer{
        private int a;
        private int b;
        private int c;
        private int d;
    }
}
