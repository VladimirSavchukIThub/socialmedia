package com.example.socialmedia;

import com.example.socialmedia.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SocialmediaApplication {
	public static ApplicationContext context;
	public static User currentUser = null;
	public static void main(String[] args) {
		SpringApplication.run(SocialmediaApplication.class, args);
	}

}
