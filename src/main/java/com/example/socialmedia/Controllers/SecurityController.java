package com.example.socialmedia.Controllers;

import com.example.socialmedia.SocialmediaApplication;
import com.example.socialmedia.dto.SigninRequest;
import com.example.socialmedia.dto.SignupRequest;
import com.example.socialmedia.security.JwtCore;
import com.example.socialmedia.service.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:8080")
public class SecurityController {
    private final UserDetailsServiceImpl userService;
    @Autowired
    public SecurityController(UserDetailsServiceImpl userService) {
        this.userService = userService;
    }
    @Autowired
    private JwtCore jwtCore;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
        signupRequest.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        String serviceResult = userService.newUser(signupRequest);
        if (Objects.equals(serviceResult, "Выберите другое имя")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResult);
        }
        if (Objects.equals(serviceResult, "Выберите другую почту")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResult);
        }
        return ResponseEntity.ok("Вы успешно зарегистрированы. Теперь можете войти в свой аккаунт.");
    }
    @PostMapping("/signin")
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<?> signin(@RequestBody SigninRequest signinRequest) {

        UserDetails user = userService.loadUserByUsername(signinRequest.getUserName());

        // Check if the user exists and the password matches
        if (user == null || !passwordEncoder.matches(signinRequest.getPassword(), user.getPassword())) {
            log.info("Ошибка авторизации пользователя " + signinRequest.getUserName());
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        String jwt = jwtCore.generateToken(user);

        SocialmediaApplication.currentUser = userService.loadUserEntityByUsername(signinRequest.getUserName());
        log.info("Вход прошёл успешно");
        return ResponseEntity.ok(jwt);
    }
    private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);
    public void someMethod() {
        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warning message");
        logger.error("Error message");
    }
}
