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
import java.util.Optional;

@Service
public class BorrowedBookServices {

    @Autowired
    private BorrowBookRepo borrowedBookRepository;

    @Autowired
    private BookRepo bookRepository;

    @Autowired
    private UserRepo userRepository;
    private BorrowedBook borrowedBook;

    private int borrowBookIdOfBook;
    private int borrowBookIdOfUser;

    // borrowBook
    public void borrowBook(int userId, int bookId) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));


        if (book.getAvailableCopies() <= 0) {
            throw new IllegalStateException("Book is not available for borrowing because no available copies");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if(user.getUserLimit() < 5){
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

            user.setUserLimit(user.getUserLimit() + 1);
            userRepository.save(user);
            // Save the borrowing record to the database
            borrowedBookRepository.save(borrowedBook);
        }else {
            throw new IllegalArgumentException("User exceed the limit");

        }

    }

    // get
    public List<BorrowedBook> getBorrowedBooks() {
        return borrowedBookRepository.findAll();
    }

    // return
    public void returnBorrowedBook(int userId, int bookId) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if(checkBorrowedBooksByBookId(bookId) && checkBorrowedBooksByUserId(userId)){
            if(borrowBookIdOfBook == borrowBookIdOfUser){
                Optional<BorrowedBook> borrowedBook = borrowedBookRepository.findById(borrowBookIdOfUser);

                if(borrowedBook.isPresent()){
                    borrowedBook.get().setStatus("returned");
                    borrowedBook.get().setReturnDate(new Date());

                    // Update book availability
                    book.setAvailableCopies(book.getAvailableCopies() + 1);
                    bookRepository.save(book);

                    user.setUserLimit(user.getUserLimit() - 1);
                    userRepository.save(user);

                }
            }
            else {
                throw new IllegalArgumentException("this user didn't borrow this book ");
            }

        }



    }
    public Boolean checkBorrowedBooksByBookId(int bookId) {

        List<BorrowedBook> borrowedBookList = borrowedBookRepository.findAll();
        boolean hasBorrowedBooks = false;
        for (BorrowedBook borrowedBook : borrowedBookList) {
            if (borrowedBook.getBook().getBookID()== bookId) {
                hasBorrowedBooks = true;
                // id
                borrowBookIdOfBook = borrowedBook.getId();
                return hasBorrowedBooks ;
            }
        }
        return hasBorrowedBooks;
    }
    public Boolean checkBorrowedBooksByUserId(int userId) {

        List<BorrowedBook> borrowedBookList = borrowedBookRepository.findAll();
        boolean hasBorrowedBooks = false;
        for (BorrowedBook borrowedBook : borrowedBookList) {
            if (borrowedBook.getUser().getUserID() == userId) {
                hasBorrowedBooks = true;
                //id
                borrowBookIdOfUser = borrowedBook.getId();
                return hasBorrowedBooks ;
            }
        }
        return hasBorrowedBooks;
    }
//
}

