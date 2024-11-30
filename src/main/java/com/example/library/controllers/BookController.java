package com.example.library.controllers;

import com.example.library.models.Book;
import com.example.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Add a new book
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookRepository.save(book);
        return ResponseEntity.status(201).body(savedBook);  // Return HTTP 201 (Created)
    }

    // Delete a book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.deleteById(id);
            return ResponseEntity.noContent().build();  // Return HTTP 204 (No Content)
        }
        return ResponseEntity.notFound().build();  // Return HTTP 404 (Not Found) if book doesn't exist
    }
}