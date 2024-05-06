package com.project.librarySystem.book.services;

import com.project.librarySystem.models.Book;
import com.project.librarySystem.models.User;
import com.project.librarySystem.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddBookServices {

    @Autowired
    private BookRepo bookRepo;


    public void addBook(Book book) {
        bookRepo.save(book);
    }

    public boolean isTitleAvailable(String title) {
        return bookRepo.findByTitle(title) == null;
    }

    public boolean isISBNAvailable(String ISBN) {
        return bookRepo.findByISBN(ISBN) == null;
    }


}
