package com.example.livres;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.livres.Model.Book;

import java.util.ArrayList;
import java.util.List;

public class ListBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_book);

        VolleySingleton.getInstance(ListBookActivity.this).getBooks(new Consumer<List<Book>>() {
            @Override
            public void accept(List<Book> books) {
                ArrayList<Book> bookList = new ArrayList<>();
                for (Book book : books) {
                    bookList.add(book);
                }

                ListView lvBook = findViewById(R.id.lvBook);
                BookAdapter adapter = new BookAdapter(ListBookActivity.this, bookList);
                lvBook.setAdapter(adapter);
            }
        });

        FloatingActionButton fabCreateBook = findViewById(R.id.fabCreateBook);
        fabCreateBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListBookActivity.this, DescriptionBookActivity.class));
            }
        });
    }
}
