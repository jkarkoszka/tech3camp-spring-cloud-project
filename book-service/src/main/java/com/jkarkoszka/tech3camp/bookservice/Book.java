package com.jkarkoszka.tech3camp.bookservice;

public class Book {

    private final String title;
    private final Integer authorId;

    public Book(String title, Integer authorId) {
        this.title = title;
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public Integer getAuthorId() {
        return authorId;
    }
}
