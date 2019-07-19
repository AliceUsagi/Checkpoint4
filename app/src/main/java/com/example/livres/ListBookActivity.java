package com.example.livres;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.util.Consumer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
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
            public void accept(final List<Book> books) {
                ArrayList<Book> bookList = new ArrayList<>();
                for (Book book : books) {
                    bookList.add(book);
                }

                final ListView lvBook = findViewById(R.id.lvBook);
                BookAdapter adapter = new BookAdapter(ListBookActivity.this, bookList);
                lvBook.setAdapter(adapter);

                lvBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Book book = books.get(position);
                        Intent intent = new Intent(ListBookActivity.this, OpenBookActivity.class);
                        intent.putExtra("keyTitle", book.getTitle());
                        intent.putExtra("keyAuthor", book.getAuthor());
                        intent.putExtra("keyResume", book.getResume());
                        startActivity(intent);
                    }
                });
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
