package com.example.livres;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.livres.Model.Book;
import com.example.livres.Model.User;

public class DescriptionBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_book);

        Button btSend = findViewById(R.id.btSend);
        btSend.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                EditText etDescriptionTitle = findViewById(R.id.etDescriptionTitle);
                EditText etDescriptionAuthor = findViewById(R.id.etDescriptionAuthor);
                EditText etDescriptionResume = findViewById(R.id.etDescriptionResume);

                String title = etDescriptionTitle.getText().toString();
                String author = etDescriptionAuthor.getText().toString();
                String resume = etDescriptionResume.getText().toString();

                final User user = UserSingleton.getInstance().getUser();
                final Book book = new Book();

                book.setTitle(title);
                book.setAuthor(author);
                book.setResume(resume);

                VolleySingleton.getInstance(DescriptionBookActivity.this).postBook(book, user, new Consumer<Book>(){
                    @Override
                    public void accept(Book book) {
                        BookSingleton.getInstance().setBook(book);
                        Intent intent = new Intent(DescriptionBookActivity.this, ListBookActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}