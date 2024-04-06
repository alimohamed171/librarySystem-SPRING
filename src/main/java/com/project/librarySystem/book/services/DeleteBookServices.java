package com.project.librarySystem.book.services;

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
}
