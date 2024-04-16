package com.project.librarySystem.borrowBook.services;

import com.project.librarySystem.models.Book;
import com.project.librarySystem.models.BorrowedBook;
import com.project.librarySystem.models.User;
import com.project.librarySystem.repository.BookRepo;
import com.project.librarySystem.repository.BorrowBookRepo;
import com.project.librarySystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class BorrowedBookServices {

    @Autowired
    private BorrowBookRepo borrowedBookRepository;

    @Autowired
    private BookRepo bookRepository;

    @Autowired
    private UserRepo userRepository;

    public void borrowBook(int userId, int bookId) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));


        if (book.getAvailableCopies() <= 0) {
            throw new IllegalStateException("Book is not available for borrowing because no available copies");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Create a new BorrowedBook entity
        BorrowedBook borrowedBook = new BorrowedBook();
        borrowedBook.setBook(book);
        borrowedBook.setUser(user);
        borrowedBook.setBorrowDate(new Date());
        LocalDate currentDate = LocalDate.now();
        LocalDate returnDate = currentDate.plusWeeks(1);
        borrowedBook.setReturnDate(java.sql.Date.valueOf(returnDate));
        borrowedBook.setStatus("Borrowed");

        // Update book availability
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);

        // Save the borrowing record to the database
        borrowedBookRepository.save(borrowedBook);
    }

    public List<BorrowedBook> getBorrowedBooks(){
        return borrowedBookRepository.findAll();
    }

}
