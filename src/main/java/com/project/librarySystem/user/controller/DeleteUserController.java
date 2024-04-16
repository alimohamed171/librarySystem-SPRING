package com.project.librarySystem.user.controller;

import com.project.librarySystem.book.services.DeleteBookServices;
import com.project.librarySystem.user.services.DeleteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DeleteUserController {


    @Autowired
    private DeleteUserService deleteUserService;

    @RequestMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
        deleteUserService.deleteById(id);
        return ResponseEntity.ok("user with ID " + id + " deleted successfully");// Return a 204 No Content response
    }

}
