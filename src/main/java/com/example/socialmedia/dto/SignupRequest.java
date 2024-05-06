package com.example.socialmedia.dto;

import lombok.Data;

@Data
public class SignupRequest {
    private String userName;
    private String password;
    private Long phoneNumber;
    private String address;
    private String email;

}
