package com.birdguide.Birdguide_BE.controller;

import com.birdguide.Birdguide_BE.model.User;
import com.birdguide.Birdguide_BE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {

        Optional<User> userExists = userService.findByUsername(user.getUsername());
        if(userExists.isPresent()){
            return ResponseEntity.status(401).body("Nome de usuário já existe.");
        }

        userExists = userService.findByEmail(user.getEmail());
        if(userExists.isPresent()){
            return ResponseEntity.status(401).body("Email já registrado.");
        }

        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok("Usuário registrado com sucesso.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        Optional<User> loggedInUser = userService.loginUser(user.getUsername(), user.getSenha());
        if (loggedInUser.isPresent()) {
            return ResponseEntity.ok("Login efetuado com sucesso.");
        }
        return ResponseEntity.status(401).body("Nome de usuário ou senha inválidos.");
    }
}
