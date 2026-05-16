package com.ggomezromero.model;

public class Book {
    private final String id;
    private final String title;
    private final String author;
    private final int year;

    public Book(String id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getId()     { return id; }
    public String getTitle()  { return title; }
    public String getAuthor() { return author; }
    public int getYear()      { return year; }
}
