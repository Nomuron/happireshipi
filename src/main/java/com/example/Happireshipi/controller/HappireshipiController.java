package com.example.Happireshipi.controller;

import com.example.Happireshipi.dao.Meal;
import com.example.Happireshipi.service.IHappireshipiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/")
public class HappireshipiController {

    private IHappireshipiService happireshipiService;

    public HappireshipiController(IHappireshipiService happireshipiService) {
        this.happireshipiService = happireshipiService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello world!";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meal> findMealById(@PathVariable Integer id) {
        return ResponseEntity.of(happireshipiService.findById(id));
    }

    @GetMapping("/all-meals")
    public ResponseEntity<List<Meal>> findAllMeals() {
        return ResponseEntity.ok(happireshipiService.findAll());
    }
}
