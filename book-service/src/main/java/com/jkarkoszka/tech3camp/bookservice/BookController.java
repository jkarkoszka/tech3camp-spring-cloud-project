package com.jkarkoszka.tech3camp.bookservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BookController {

    private final AuthorService authorService;
    private final BookService bookService;


    public BookController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping("/{bookId}")
    public BookRest getBook(@PathVariable("bookId") Integer bookId) {
        Optional<Book> book = bookService.getBook(bookId);
        if (!book.isPresent()) {
            throw new BookNotFoundException();
        }
        Author author = authorService.getAuthor(book.get().getAuthorId());
        return new BookRest(book.get().getTitle(), author);
    }
}
