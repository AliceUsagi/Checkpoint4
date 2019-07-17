package com.example.livres;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.livres.Model.Book;

import java.util.ArrayList;
import java.util.List;

public class ListBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_book);

        List<Book> books = new ArrayList<>();
        books.add(new Book("Harry Potter"));
        books.add(new Book("Seigneur des anneaux"));
        books.add(new Book("blabla"));
        books.add(new Book("blablabla"));

        ListView lvBooks = findViewById(R.id.lvBook);
        BookAdapter adapter = new BookAdapter(ListBookActivity.this, books);
        lvBooks.setAdapter(adapter);
    }
}
