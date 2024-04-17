package com.project.librarySystem.book.services;

import com.project.librarySystem.models.Book;
import com.project.librarySystem.models.BorrowedBook;
import com.project.librarySystem.repository.BookRepo;
import com.project.librarySystem.repository.BorrowBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteBookServices {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private BorrowBookRepo borrowBookRepo;
    public void delete(Book book) {
        bookRepo.delete(book);
    }
    public void deleteById(int id) {

        bookRepo.deleteById(id);
    }
    public boolean bookIsExist(int id) {
        return bookRepo.findById(id).isPresent();
    }

    public Boolean checkBorrowedBooksByBookId(int id) {

        List<BorrowedBook> borrowedBookList = borrowBookRepo.findAll();
        boolean hasBorrowedBooks = false;
        for (BorrowedBook borrowedBook : borrowedBookList) {
            if (borrowedBook.getBook().getBookID()== id) {
                hasBorrowedBooks = true;
                return hasBorrowedBooks ;
            }
        }
        return hasBorrowedBooks;
    }
}
