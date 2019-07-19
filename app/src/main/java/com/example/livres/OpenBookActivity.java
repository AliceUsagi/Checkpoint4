package com.example.livres;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.livres.Model.Book;

public class OpenBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_book);

        Intent intent = getIntent();
        String titleBook = intent.getStringExtra("keyTitle");
        String authorBook = intent.getStringExtra("keyAuthor");
        String resumeBook = intent.getStringExtra("keyResume");

        TextView tvTitle = findViewById(R.id.tvTitleOpenBook);
        TextView tvAuthor = findViewById(R.id.tvAuthorOpenBook);
        TextView tvResume = findViewById(R.id.tvResumeOpenBook);

        tvTitle.setText(titleBook);
        tvAuthor.setText(authorBook);
        tvResume.setText(resumeBook);
    }
}
