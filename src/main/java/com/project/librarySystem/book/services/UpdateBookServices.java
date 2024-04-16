package com.project.librarySystem.book.services;

import com.project.librarySystem.models.Book;
import com.project.librarySystem.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateBookServices {
    @Autowired
    private BookRepo bookRepo;
    public String updateBook(int id, Book bookDetails){

        if(bookIsExist(id)){
            bookRepo.save(bookDetails);
            return "book is updated";
        }
        return "book is not exist";
    }
    private boolean bookIsExist(int id) {
        return bookRepo.findById(id).isPresent();
    }

}
