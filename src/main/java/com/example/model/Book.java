package com.example.model;

public class Book {
    private String id;
    private String title;
    private String author;
    private int year;
    private String category;
    private boolean available;

    public Book(){
        this.available = true;
    }

    public Book(String id, String title, String author, int year, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.category = category;
        this.available = true;
    }

    public Book(String idString, String title, String author, int year, String category, boolean available) {
        this.id = idString;
        this.title = title;
        this.author = author;
        this.year = year;
        this.category = category;
        this.available = available;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", category='" + category + '\'' +
                ", available=" + available +
                '}';
    }
}
