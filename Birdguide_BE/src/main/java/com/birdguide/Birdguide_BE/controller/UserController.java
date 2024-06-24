package com.birdguide.Birdguide_BE.controller;

import com.birdguide.Birdguide_BE.model.Bird;
import com.birdguide.Birdguide_BE.model.User;
import com.birdguide.Birdguide_BE.service.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:5173")
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
    public ResponseEntity<Long> loginUser(@RequestBody User user) {
        Optional<User> loggedInUser = userService.loginUser(user.getUsername(), user.getSenha());
        if (loggedInUser.isPresent()) {
            userService.setLoggedUser(loggedInUser.get().getId());
            return ResponseEntity.ok(loggedInUser.get().getId());
        }
        return ResponseEntity.status(401).body(null);
    }

    @GetMapping("/{userId}/favorites")
    public ResponseEntity<?> getFavorites(@PathVariable Long userId) {
        Optional<Set<Bird>> favorites = userService.getFavorites(userId);
        if (favorites.isPresent()) {
            return ResponseEntity.ok(favorites.get());
        }
        return ResponseEntity.status(404).body("Usuário não encontrado.");
    }

    @PostMapping("/{userId}/favorites/{birdId}")
    public ResponseEntity<String> addFavorite(@PathVariable Long userId, @PathVariable Long birdId) {
        Optional<User> user = userService.addFavorite(userId, birdId);
        if (user.isPresent()) {
            return ResponseEntity.ok("Ave adicionada aos favoritos com sucesso.");
        }
        return ResponseEntity.status(404).body("Usuário ou ave não encontrados.");
    }

    @DeleteMapping("/{userId}/favorites/{birdId}")
    public ResponseEntity<String> removeFavorite(@PathVariable Long userId, @PathVariable Long birdId) {
        Optional<User> user = userService.removeFavorite(userId, birdId);
        if (user.isPresent()) {
            return ResponseEntity.ok("Ave removida dos favoritos com sucesso.");
        }
        return ResponseEntity.status(404).body("Usuário ou ave não encontrados.");
    }

    @GetMapping("/{userId}/profile")
    public ResponseEntity<User> getUserProfile(@PathVariable Long userId) {
        Optional<User> user = userService.findById(userId);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.status(404).body(null);
    }
}
