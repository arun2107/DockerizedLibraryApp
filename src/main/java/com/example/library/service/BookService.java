package com.example.library.service;

import com.example.library.models.Book;
import com.example.library.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    // Constructor-based dependency injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Save a book
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // Delete a book by ID
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}