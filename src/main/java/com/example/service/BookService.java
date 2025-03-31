package com.example.service;

import com.example.model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class BookService {
    private List<Book> bookList;
    
    public BookService() {
        this.bookList = new ArrayList<>();
    }
    
    // Add a new book with auto-generated ID
    public Book addBook(String title, String author, int year, String category) {
        String id = UUID.randomUUID().toString().substring(0, 8);
        Book newBook = new Book(id, title, author, year, category);
        bookList.add(newBook);
        return newBook;
    }
    
    // Add an existing book object
    public void addBook(Book book) {
        Optional.ofNullable(book.getId())
                .filter(id -> !id.isEmpty())
                .ifPresentOrElse(
                        id -> {}, // Do nothing if ID exists
                        () -> book.setId(UUID.randomUUID().toString().substring(0, 8))
                );
        bookList.add(book);
    }
    
    // Search books by title (case-insensitive partial match)
    public List<Book> searchBooksByTitle(String title) {
        return Optional.ofNullable(title)
                .map(t -> bookList.stream()
                        .filter(book -> book.getTitle().toLowerCase().contains(t.toLowerCase()))
                        .collect(Collectors.toList()))
                .orElseGet(ArrayList::new);
    }
    
    // Search books by author (case-insensitive partial match)
    public List<Book> searchBooksByAuthor(String author) {
        return bookList.stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    // Search books by category (case-insensitive partial match)
    public List<Book> searchBooksByCategory(String category) {
        return bookList.stream()
                .filter(book -> book.getCategory().toLowerCase().contains(category.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    // Search books by year
    public List<Book> searchBooksByYear(int year) {
        return bookList.stream()
                .filter(book -> book.getYear() == year)
                .collect(Collectors.toList());
    }
    
    // Search books by availability
    public List<Book> searchBooksByAvailability(boolean available) {
        return bookList.stream()
                .filter(book -> book.isAvailable() == available)
                .collect(Collectors.toList());
    }
    
    // Get book by ID
    public Optional<Book> getBookById(String id) {
        return bookList.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }
    
    // List all books
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookList);
    }
    
    // Remove a book by ID
    public boolean removeBook(String id) {
        return Optional.ofNullable(id)
                .map(bookId -> bookList.removeIf(book -> book.getId().equals(bookId)))
                .orElse(false);
    }
}