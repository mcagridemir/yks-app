package com.example.yks_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DenemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deneme);
    }

    public void quizzezOnClick(View view) {
        Intent intent = new Intent(DenemeActivity.this, QuizListActivity.class);
        startActivity(intent);
    }
}
