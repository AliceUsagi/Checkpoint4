package com.example.livres;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.livres.Model.Book;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, List<Book> movies) {
        super(context, 0, movies);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_book, parent, false);
        }
        Book book = getItem(position);
        TextView tvMovieTitle = convertView.findViewById(R.id.tvBookTitle);
        tvMovieTitle.setText(book.getTitle());

        return convertView;
    }
}
