package com.project.librarySystem.models;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookID;
    private String title;
    private String author;
    private String ISBN;
//    private String imageLink;
    private int rackNumber;
    private int availableCopies;
    private int totalCopies;


}
