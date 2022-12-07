package com.example.Happireshipi.service;

import com.example.Happireshipi.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Boolean isCorrectAdmin(String login, String password) {
        return userRepository.findByCredentials(login, password) != null;
    }
}
