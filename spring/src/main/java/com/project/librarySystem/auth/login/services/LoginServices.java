package com.project.librarySystem.auth.login.services;


import com.project.librarySystem.models.User;
import com.project.librarySystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServices {

    @Autowired
    private UserRepo repo;


    public User login(String userName, String password) {
        return repo.findByUserNameAndPassword(userName, password);
    }


}
