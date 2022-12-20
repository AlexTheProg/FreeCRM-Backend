package com.example.freecrmbackend.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final String userId;
    private final String firstName;
    private final String lastName;


    public User(String userId, String firstName, String lastName){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
