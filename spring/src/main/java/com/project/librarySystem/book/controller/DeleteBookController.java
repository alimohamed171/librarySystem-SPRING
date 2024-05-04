package com.project.librarySystem.book.controller;

import com.project.librarySystem.book.services.DeleteBookServices;
import com.project.librarySystem.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class DeleteBookController {
    @Autowired
    private DeleteBookServices deleteBookServices;

    @RequestMapping("/deleteBook/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable int id) {
        if (deleteBookServices.bookIsExist(id)) {
            if(deleteBookServices.checkBorrowedBooksByBookId(id)){

                return ResponseEntity.ok("this book is already borrowed");// Return a 204 No Content response

            }
            else{
                deleteBookServices.deleteById(id);
                return ResponseEntity.ok("Book with ID " + id + " deleted successfully");

            }

        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("book with provided id does not exist");

    }



    // @PostMapping("/deleteBook")
// public ResponseEntity<Void> deleteBook(@RequestBody Book book) {
//     bookService.deleteBook(book);
//     return ResponseEntity.noContent().build();
// }
}