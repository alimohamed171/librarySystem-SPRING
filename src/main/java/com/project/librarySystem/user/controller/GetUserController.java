package com.project.librarySystem.user.controller;


import com.project.librarySystem.models.User;
import com.project.librarySystem.user.services.GetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class GetUserController {

    @Autowired
    GetUserService getUserService;

    @GetMapping("/getAllUsers")
    public List<User> getAlUsers(){
        return  getUserService.getAllUsers();
    }

}
