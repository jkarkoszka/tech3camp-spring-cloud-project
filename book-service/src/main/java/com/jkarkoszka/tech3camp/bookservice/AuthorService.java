package com.jkarkoszka.tech3camp.bookservice;

import org.springframework.stereotype.Component;

@Component
public class AuthorService {

    private final AuthorClient authorClient;

    public AuthorService(AuthorClient authorClient) {
        this.authorClient = authorClient;
    }

    public Author getAuthor(Integer authorId) {
        return authorClient.getAuthor(authorId);
    }
}
