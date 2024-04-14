package com.project.librarySystem.book.controller;

import com.project.librarySystem.book.services.GetBookServices;
import com.project.librarySystem.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class GetBookController {
    @Autowired
    private GetBookServices getBookServices;
    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks(){
        return  getBookServices.getAllBooks();
    }


}
