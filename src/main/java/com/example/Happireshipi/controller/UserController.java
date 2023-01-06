package com.example.Happireshipi.controller;

import com.example.Happireshipi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {

    private final UserService adminService;

    public UserController(UserService adminService) {
        this.adminService = adminService;
    }

    @CrossOrigin
    @GetMapping("/admin")
    public ResponseEntity<Boolean> isCorrectAdmin(
            @RequestHeader String login,
            @RequestHeader String password
    ) {
        return ResponseEntity.ok(adminService.isCorrectAdmin(login, password));
    }
}
