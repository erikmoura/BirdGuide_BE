package com.birdguide.Birdguide_BE.service;

import com.birdguide.Birdguide_BE.model.Bird;
import com.birdguide.Birdguide_BE.model.User;
import com.birdguide.Birdguide_BE.repository.BirdRepository;
import com.birdguide.Birdguide_BE.repository.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BirdRepository birdRepository;

    @Setter
    private long loggedUser;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    public Optional<User> loginUser(String username, String senha) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && user.get().getSenha().equals(senha)) {
            return user;
        }
        return Optional.empty();
    }

    public Optional<User> addFavorite(Long userId, Long birdId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Bird> birdOpt = birdRepository.findById(birdId);

        if (userOpt.isPresent() && birdOpt.isPresent()) {
            User user = userOpt.get();
            Bird bird = birdOpt.get();
            user.getFavorites().add(bird);
            userRepository.save(user);
            return Optional.of(user);
        }
        return Optional.empty();
    }

    public Optional<User> removeFavorite(Long userId, Long birdId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Bird> birdOpt = birdRepository.findById(birdId);

        if (userOpt.isPresent() && birdOpt.isPresent()) {
            User user = userOpt.get();
            Bird bird = birdOpt.get();
            user.getFavorites().remove(bird);
            userRepository.save(user);
            return Optional.of(user);
        }
        return Optional.empty();
    }

    public Optional<Set<Bird>> getFavorites(Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        return userOpt.map(User::getFavorites);
    }
}
