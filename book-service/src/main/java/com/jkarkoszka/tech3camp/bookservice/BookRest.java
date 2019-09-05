package com.jkarkoszka.tech3camp.bookservice;

public class BookRest {

    private final String title;
    private final Author author;

    public BookRest(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }
}
