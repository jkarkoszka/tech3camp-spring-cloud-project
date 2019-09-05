package com.jkarkoszka.tech3camp.authorservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthorController {

    private Map<Integer, Author> authors = new HashMap<>();

    public AuthorController() {
        authors.put(1, new Author("Adam", "Mickiewicz"));
        authors.put(2, new Author("Henryk", "Sienkiewicz"));
        authors.put(3, new Author("Jan", "Brzechwa"));
    }

    @GetMapping(value = "/{id}")
    public Author getAuthor(@PathVariable("id") Integer id) {
        if (!authors.containsKey(id)) {
            throw new AuthorNotFoundException();
        }
        return authors.get(id);
    }
}
