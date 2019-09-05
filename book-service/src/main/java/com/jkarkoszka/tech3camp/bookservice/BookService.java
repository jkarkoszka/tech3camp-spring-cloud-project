package com.jkarkoszka.tech3camp.bookservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class BookService {

    private Map<Integer, Book> books = new HashMap<>();

    public BookService() {
        books.put(1, new Book("Pan Tadeusz", 1));
        books.put(2, new Book("W pustyni i w puszcyz", 2));
        books.put(3, new Book("Akademia pana Kleksa", 3));
    }

    @HystrixCommand(fallbackMethod = "defaultBook")
    public Optional<Book> getBook(Integer bookId) {
        if (!books.containsKey(bookId)) {
            return Optional.empty();
        }
        return Optional.of(books.get(bookId));
    }

    private Optional<Book> defaultBook(Integer bookId) {
        return Optional.of(new Book("Default book", 3));
    }
}
