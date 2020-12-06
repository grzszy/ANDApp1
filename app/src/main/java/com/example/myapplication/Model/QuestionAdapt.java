package com.example.myapplication.Model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public abstract class QuestionAdapt extends RecyclerView.Adapter<QuestionAdapt.ViewHolder> {

    int count;

    public interface OnItemClickListener {
        void OnItemClick(List<Question> questions);
    }

    private List<Question> questions = new ArrayList<>();
    private final OnItemClickListener listener;

    public QuestionAdapt(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.quiz_activity, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(questions, listener);
        holder.question.setText(questions.get(position).getQuestion());


    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
        notifyDataSetChanged();
    }

    public int getCount() {
        return count;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView question;
        Button start;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            question = itemView.findViewById(R.id.question);
            start = itemView.findViewById(R.id.start);
        }

        public void bind(final List<Question> questions, final QuestionAdapt.OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int i = 0; i < questions.size(); i++) {
                        listener.OnItemClick(questions);
                    }
                }
            });

        }


    }
}
