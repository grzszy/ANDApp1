package com.example.myapplication.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.Model.API_Interface;
import com.example.myapplication.Model.API_Response;
import com.example.myapplication.Model.Dao;
import com.example.myapplication.Model.Database;
import com.example.myapplication.Model.Question;
import com.example.myapplication.Model.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizRepository {

    private Dao dao;
    private static QuizRepository instance;
    private MutableLiveData<Question> que;
    private LiveData<List<Question>> questions;
    public LiveData<Question> getQuestion(){
        return que;
    }

    public LiveData<Question> updateQuestion() {
        API_Interface androidAPI = ServiceGenerator.getAPI_interface();
        Call<API_Response> getQue = androidAPI.getQuestion(que.getValue().getQue(),que.getValue().getAnsA(), que.getValue().getAnsB(),
        que.getValue().getAnsC(), que.getValue().getAnsD(), que.getValue().getQue_ID());

        getQue.enqueue(new Callback<API_Response>() {
            @Override
            public void onResponse(Call<API_Response> call, Response<API_Response> response) {
                if (response.equals(true) && response.isSuccessful())
                {
                    que.setValue(response.body().getQuestion());
                }

            }

            @Override
            public void onFailure(Call<API_Response> call, Throwable t) {
                System.out.println("Something wrong in the API!");
                t.getCause();
                t.getMessage();
                t.printStackTrace();
            }
        });

        return null;
    }

    private static class InsertQuestionAsync extends AsyncTask<Question, Void, Void> {
        private Dao dao;

        private InsertQuestionAsync(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Question... questions) {
            dao.insertQuestion(questions[0]);
            return null;
        }
    }

    private static class DeleteAllQuestionAsync extends AsyncTask<Void, Void, Void> {
        private Dao dao;

        private DeleteAllQuestionAsync(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllNotes();
            return null;
        }
    }

    public static synchronized QuizRepository getInstance(Application application) {
        if (instance == null) {
            instance = new QuizRepository(application);
        }
        return instance;
    }
    public LiveData<Question> getAllQuestions() {
        return que;
    }

    private QuizRepository(Application application) {
        questions = new MutableLiveData<>();
        Database database = Database.getInstance(application);
        dao = (Dao) database.questionDao();
        questions = dao.getAllQuestions();
    }



    public void insert(Question question) {
        new InsertQuestionAsync(dao).execute(question);
    }

    public void deleteAllNotes() {
        new DeleteAllQuestionAsync(dao).execute();

    }
}
