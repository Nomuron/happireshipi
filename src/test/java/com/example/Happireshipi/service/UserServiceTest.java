package com.example.Happireshipi.service;

import com.example.Happireshipi.dao.User;
import com.example.Happireshipi.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void isUserAdmin() {
        when(userRepository.findByCredentials("", "")).thenReturn(new User());

        Boolean admins = userService.isCorrectAdmin("", "");

        assertEquals(admins, true);
    }
}
