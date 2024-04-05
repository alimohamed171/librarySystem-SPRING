package com.project.librarySystem.auth.login.controller;

import com.project.librarySystem.auth.login.model.LoginRequest;
import com.project.librarySystem.auth.login.services.LoginServices;
import com.project.librarySystem.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class LoginController {
    @Autowired
    private LoginServices loginServices;
    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest loginRequest
    ) {
        User user = loginServices.login(loginRequest.getUserName(), loginRequest.getPassword());
        if (user != null) {

            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password. Please try again.");
        }

    }


}
