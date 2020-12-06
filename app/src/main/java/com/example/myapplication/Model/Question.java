package com.example.myapplication.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "questions")
public class Question {



    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int que_ID;
    private String ansA;
    private String ansB;
    private String ansC;
    private String ansD;

    private String answer;
    private String que;

    public Question(String que, String ansA, String ansB, String ansC, String ansD, int que_ID) {
        this.que = que;
        this.ansA = ansA;
        this.ansB = ansB;
        this.ansC = ansC;
        this.ansD = ansD;
        this.que_ID = que_ID;
    }

    public Question()
    {};


    public void setQue(String que)
    {
        this.que = que;
    }
    public String getQue() {
        return que;
    }

   public int getQue_ID()
    {
        return que_ID;
    }
    public void setQue_ID(int que_id)
    {
        this.que = que;
    }
    public String getQuestion()
    {
        return que;
    }


    public void setQuestion(String que)
    {
        this.que = que;
    }
    public String getAnsA()
    {
        return ansA;
    }

    public void setAnsA(String ansA)
    {
        this.ansA = ansA;
    }
    public String getAnsB()
    {
        return ansB;
    }

    public void setAnsB(String ansB)
    {
        this.ansA = ansB;
    }
    public String getAnsC()
    {
        return ansC;
    }

    public void setAnsC(String ansC)
    {
        this.ansA = ansC;
    }
    public String getAnsD()
    {
        return ansD;
    }

    public void setAnsD(String ansD)
    {
        this.ansA = ansD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer)
    {this.answer = answer;}

}



