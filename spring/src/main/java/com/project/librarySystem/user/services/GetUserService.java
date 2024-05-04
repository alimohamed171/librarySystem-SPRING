package com.project.librarySystem.user.services;

import com.project.librarySystem.models.User;
import com.project.librarySystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GetUserService {

    @Autowired
    private UserRepo userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
