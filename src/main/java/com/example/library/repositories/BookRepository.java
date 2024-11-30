package com.example.library.repositories;

import com.example.library.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    // You can add custom queries here if needed, but this basic repository will work for basic CRUD operations
}