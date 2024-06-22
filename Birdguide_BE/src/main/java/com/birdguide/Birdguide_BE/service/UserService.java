package com.birdguide.Birdguide_BE.service;

import com.birdguide.Birdguide_BE.model.User;
import com.birdguide.Birdguide_BE.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> loginUser(String username, String senha) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && user.get().getSenha().equals(senha)) {
            return user;
        }
        return Optional.empty();
    }
}
