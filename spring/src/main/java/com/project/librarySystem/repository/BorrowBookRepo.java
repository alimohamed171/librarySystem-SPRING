package com.project.librarySystem.repository;

import com.project.librarySystem.models.Book;
import com.project.librarySystem.models.BorrowedBook;
import com.project.librarySystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BorrowBookRepo extends JpaRepository<BorrowedBook,Integer> {


//    List<BorrowedBook> findByUserId(int userId);
//Optional<BorrowedBook> findByUserIdAndBookId(int userId, int bookId);

}
