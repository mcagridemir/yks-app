package com.example.yks_app;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder> {

    QuizListActivity quizListActivity;

    private ArrayList<Quiz> mQuizList;

    private Listener listener;

    interface Listener {
        void onClick(int position);
    }

    public static class QuizViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;

        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public QuizViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
            //cardView = v;
        }
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public QuizAdapter(ArrayList<Quiz> mQuizList) {
        this.mQuizList = mQuizList;
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_quiz_list, parent, false);
        QuizViewHolder quizViewHolder = new QuizViewHolder(v);
        return quizViewHolder;
        /*CardView cv = (CardView) LayoutInflater.from(parent.getContext()).
                inflate(R.layout.fragment_quiz_list, parent, false);
        return new RecyclerView.ViewHolder(cv); */
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, final int position) {

        final CardView cardView = holder.cardView;

        Quiz currentItem = mQuizList.get(position);

        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  switch (position) {
                    case 0:
                        Intent intent0 = new Intent(v.getContext(), QuizActivity.class);
                        //intent0.putExtra(QuizActivity.EXTRA_QUESTIONID, position);
                        v.getContext().startActivity(intent0);
                    case 1:
                        Intent intent1 = new Intent(v.getContext(), QuizActivity.class);
                        v.getContext().startActivity(intent1);
                } */
              Intent intent = new Intent(v.getContext(), StartingScreenActivity.class);
              v.getContext().startActivity(intent);
            }
        });

        /*cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
                switch (position) {
                    case 0:
                        Intent intent0 = new Intent(v.getContext(), QuizActivity.class);
                        v.getContext().startActivity(intent0);
                    case 1:
                        Intent intent1 = new Intent(v.getContext(), QuizActivity.class);
                        v.getContext().startActivity(intent1);
                }
            }
        }); */


        /*cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cardView.getContext(), QuizActivity.class);
                intent.putExtra(QuizActivity.EXTRA_QUESTIONID, position);
                cardView.getContext().startActivity(intent);
            }
        }); */
    }

    @Override
    public int getItemCount() {
        return mQuizList.size();
    }
}

