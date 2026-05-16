package com.ggomezromero.controller;

import com.ggomezromero.model.Book;
import com.ggomezromero.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping
    public List<Book> books() {
        return bookService.findAll();
    }

    @QueryMapping
    public Book bookById(@Argument String id) {
        return bookService.findById(id).orElse(null);
    }

    @MutationMapping
    public Book addBook(@Argument String title,
                        @Argument String author,
                        @Argument int year) {
        return bookService.addBook(title, author, year);
    }
}
