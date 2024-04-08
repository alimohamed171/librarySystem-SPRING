package com.project.librarySystem.book.services;

import com.project.librarySystem.models.Book;
import com.project.librarySystem.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateBookServices {
    @Autowired
    private BookRepo bookRepo;
    public Book updateBook(int id, Book bookDetails){
        return bookRepo.save(bookDetails);
    }

}
