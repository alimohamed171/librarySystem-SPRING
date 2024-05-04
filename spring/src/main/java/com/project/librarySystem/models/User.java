package com.project.librarySystem.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String userType;//normal
    private int userLimit ;

}