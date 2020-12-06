package com.example.myapplication.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@androidx.room.Dao
public interface Dao {

    @Insert
    void insertQuestion(Question question);

    @Update
    void updateQuestion(Question question);

    @Delete
    void deleteQuestion(Question question);

    @Query("DELETE FROM questions")
    void deleteAllNotes();

    @Query("SELECT * FROM questions")
    LiveData<List<Question>> getAllQuestions();


}
