package com.project.librarySystem.repository;

import com.project.librarySystem.models.Book;
import com.project.librarySystem.models.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowBookRepo extends JpaRepository<BorrowedBook,Integer> {



}