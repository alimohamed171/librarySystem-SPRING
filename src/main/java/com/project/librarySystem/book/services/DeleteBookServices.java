package com.project.librarySystem.book.services;

import com.project.librarySystem.models.Book;
import com.project.librarySystem.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteBookServices {
    @Autowired
    private BookRepo bookRepo;
    public void delete(Book book) {
        bookRepo.delete(book);
    }

    public void deleteById(int id) {

        bookRepo.deleteById(id);
    }
    public boolean bookIsExist(int id) {
        return bookRepo.findById(id).isPresent();
    }


}
