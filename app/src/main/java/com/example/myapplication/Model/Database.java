package com.example.myapplication.Model;

import android.content.Context;


import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {Question.class}, version = 1)

public abstract class Database extends RoomDatabase{

    private static Database instance;
    public abstract Dao questionDao();

    public static synchronized Database getInstance(Context context)
    {
        if (instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(), Database.class, "database").fallbackToDestructiveMigration().build();
        }
        return instance;
    }


}
