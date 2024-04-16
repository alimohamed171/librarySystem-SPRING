package com.project.librarySystem.user.services;


import com.project.librarySystem.models.BorrowedBook;
import com.project.librarySystem.repository.BorrowBookRepo;
import com.project.librarySystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeleteUserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BorrowBookRepo borrowBookRepo;


    public String deleteById(int id) {
        if(userIsExist(id)){
            if(checkBorrowedBooksByUserId(id)){
                return "user that has borrow book can't deleted";
            }else {
                userRepo.deleteById(id);
                return "user deleted";
            }
        }
        return "user not found";
    }

    private boolean userIsExist(int id) {
        return userRepo.findById(id).isPresent();
    }


    public Boolean checkBorrowedBooksByUserId(int userId) {

        List<BorrowedBook> borrowedBookList = borrowBookRepo.findAll();
        boolean hasBorrowedBooks = false;
        for (BorrowedBook borrowedBook : borrowedBookList) {
            if (borrowedBook.getUser().getUserID() == userId) {
                hasBorrowedBooks = true;
                return hasBorrowedBooks ;
            }
        }
        return hasBorrowedBooks;
    }
}
