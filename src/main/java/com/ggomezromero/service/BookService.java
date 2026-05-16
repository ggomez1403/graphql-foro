package com.ggomezromero.service;

import com.ggomezromero.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();
    private final AtomicInteger counter = new AtomicInteger(3);

    public BookService() {
        books.add(new Book("1", "Clean Code", "Robert C. Martin", 2008));
        books.add(new Book("2", "The Pragmatic Programmer", "Andrew Hunt", 1999));
        books.add(new Book("3", "Design Patterns", "Gang of Four", 1994));
    }

    public List<Book> findAll() {
        return List.copyOf(books);
    }

    public Optional<Book> findById(String id) {
        return books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();
    }

    public Book addBook(String title, String author, int year) {
        String newId = String.valueOf(counter.incrementAndGet());
        Book book = new Book(newId, title, author, year);
        books.add(book);
        return book;
    }
}
