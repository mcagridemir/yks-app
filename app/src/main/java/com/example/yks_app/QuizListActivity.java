package com.example.yks_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuizListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    //private SQLiteDatabase db;
    //private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);

        //recyclerview islemleri

        ArrayList<Quiz> quizList = new ArrayList<>();
        quizList.add(new Quiz(R.drawable.quiz_icon, getString(R.string.Quiz1),  getString(R.string.Topic)));
        quizList.add(new Quiz(R.drawable.quiz_icon, getString(R.string.Quiz2),  getString(R.string.Topic)));
        quizList.add(new Quiz(R.drawable.quiz_icon, getString(R.string.Quiz3),  getString(R.string.Topic)));
        quizList.add(new Quiz(R.drawable.quiz_icon, getString(R.string.Quiz4),  getString(R.string.Topic)));
        quizList.add(new Quiz(R.drawable.quiz_icon, getString(R.string.Quiz5),  getString(R.string.Topic)));
        quizList.add(new Quiz(R.drawable.quiz_icon, getString(R.string.Quiz6),  getString(R.string.Topic)));


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new QuizAdapter(quizList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        //veritabani islemleri ve recyclerview in clickable olmasi islemleri asagida

       /* SQLiteOpenHelper questionDatabaseHelper = new QuizDbHelper(this);
        try {
            db = questionDatabaseHelper.getReadableDatabase();
            cursor = db.query("QUESTIONS1",
                    new String[]{"_id", "TYPEOFLESSON"},
                    null, null, null, null, null);
        }catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Veritabanina ulasilamadi", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    } */

       /* public interface RecyclerViewClickListener {
            public void recyclerViewListClicked(View v, int pos);
        }  */
    }
}

