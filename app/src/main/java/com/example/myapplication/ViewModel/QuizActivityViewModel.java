package com.example.myapplication.ViewModel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Model.Question;
import com.example.myapplication.Repository.QuizRepository;

public class QuizActivityViewModel extends ViewModel {
    QuizRepository repository;

    public QuizActivityViewModel(Application app){
        super();
        repository = QuizRepository.getInstance(app);


    }

    public LiveData<Question> getQuestion()
    {
       return repository.getQuestion();
    }

    public void updateQuestion()
    {
        repository.updateQuestion();
    }





}
