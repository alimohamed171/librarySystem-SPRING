package com.project.librarySystem.repository;

import com.project.librarySystem.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Integer> {
    Book findByTitle(String title);
    Book findByISBN(String ISBN);
}
