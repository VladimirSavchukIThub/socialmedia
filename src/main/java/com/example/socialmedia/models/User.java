package com.example.socialmedia.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user", schema = "schema", catalog = "productDB")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long userId;
    @Column(name = "username")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "address")
    private String address;
    @Column(name = "phonenumber")
    private Long phoneNumber;


}
