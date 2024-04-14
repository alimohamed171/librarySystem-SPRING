package com.project.librarySystem.book.services;

import com.project.librarySystem.models.Book;
import com.project.librarySystem.repository.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetBookServices {
    private BookRepo bookRepo;
    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }


}
