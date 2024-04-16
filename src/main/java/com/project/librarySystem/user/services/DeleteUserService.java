package com.project.librarySystem.user.services;

import com.project.librarySystem.models.Book;
import com.project.librarySystem.models.User;
import com.project.librarySystem.repository.BookRepo;
import com.project.librarySystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserService {

    @Autowired
    private UserRepo userRepo;
    public void delete(User user) {
        userRepo.delete(user);
    }

    public void deleteById(int id) {

        userRepo.deleteById(id);
    }
}
