package com.example.livres;

import com.example.livres.Model.Book;

public class BookSingleton {

    private static BookSingleton instance;
    private Book book;

    private BookSingleton() {}

    public static BookSingleton getInstance() {
        if (instance == null) {
            instance = new BookSingleton();
        }
        return instance;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
