package com.project.librarySystem.book.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DeleteBookController {
     @Autowired
    private DeleteBookServices deleteBookServices;

    @RequestMapping("/deleteBook/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable int id) {
       deleteBookServices.deleteById(id);
        return ResponseEntity.ok("Book with ID " + id + " deleted successfully");
    }

    // @PostMapping("/deleteBook")
// public ResponseEntity<Void> deleteBook(@RequestBody Book book) {
//     bookService.deleteBook(book);
//     return ResponseEntity.noContent().build();// Return a 204 No Content response
// }
  
}
