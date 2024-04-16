package com.project.librarySystem.book.services;

import com.project.librarySystem.models.Book;
import com.project.librarySystem.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateBookServices {
    @Autowired
    private BookRepo bookRepo;
    public Optional<?> updateBook(int id, Book bookDetails) {
        Optional<Book> existingBook = bookRepo.findById(id);
        if (existingBook.isPresent()) {
            existingBook.get().setTitle(bookDetails.getTitle());
            existingBook.get().setAuthor(bookDetails.getAuthor());
            existingBook.get().setISBN(bookDetails.getISBN());
            existingBook.get().setRackNumber(bookDetails.getRackNumber());
            existingBook.get().setAvailableCopies(bookDetails.getAvailableCopies());
            existingBook.get().setTotalCopies(bookDetails.getTotalCopies());
            return Optional.of(bookRepo.save(existingBook.get()));
        }
        return Optional.of(("Book with id " + id + " not found"));
    }

    public boolean bookIsExist(int id) {
        return bookRepo.findById(id).isPresent();
    }
}





