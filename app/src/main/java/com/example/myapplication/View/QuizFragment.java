package com.example.myapplication.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.Model.Question;
import com.example.myapplication.R;
import com.example.myapplication.ViewModel.QuizActivityViewModel;

public class QuizFragment extends Fragment {


    Button a;
    Button b;
    Button c;
    Button d;
    TextView question;
    Button start;
    boolean answer = true;
    QuizActivityViewModel quizViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.quiz_activity, container, false);

        a = v.findViewById(R.id.a);
        b = v.findViewById(R.id.b);
        c = v.findViewById(R.id.c);
        d = v.findViewById(R.id.d);
        question = v.findViewById(R.id.question);
        start = v.findViewById(R.id.start);


        a.setVisibility(v.INVISIBLE);
        b.setVisibility(v.INVISIBLE);
        c.setVisibility(v.INVISIBLE);
        d.setVisibility(v.INVISIBLE);
        question.setVisibility(v.INVISIBLE);
        quizViewModel = new ViewModelProvider(this).get(QuizActivityViewModel.class);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.setVisibility(v.VISIBLE);
                b.setVisibility(v.VISIBLE);
                c.setVisibility(v.VISIBLE);
                d.setVisibility(v.VISIBLE);
                question.setVisibility(v.VISIBLE);
                start.setVisibility(v.INVISIBLE);
                quizViewModel.getQuestion().observe(getActivity(), new Observer<Question>() {
                    @Override
                    public void onChanged(Question question) {

                        QuizFragment.this.question.setText(question.getQuestion());
                    }
                });
            }
        });




        return v;
    }


}
