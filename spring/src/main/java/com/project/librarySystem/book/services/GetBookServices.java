package com.project.librarySystem.book.services;

import com.project.librarySystem.models.Book;
import com.project.librarySystem.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetBookServices {
    @Autowired
    private BookRepo bookRepo;
    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }


}
