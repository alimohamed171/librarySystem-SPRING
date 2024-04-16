package com.project.librarySystem.borrowBook.controller;


import com.project.librarySystem.borrowBook.services.BorrowedBookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class BorrowedBookController {


    @Autowired
    private BorrowedBookServices borrowedBookService;

    @PostMapping("/borrow-book")
    public ResponseEntity<String> borrowBook(
            @RequestParam int userId,
            @RequestParam int bookId
    ) {
        try {
            borrowedBookService.borrowBook(userId, bookId);
            return ResponseEntity.ok("Book borrowed successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to borrow book: " + e.getMessage());
        }
    }

// update return
    // copies
    // status

//get all books ()


}
