package com.example.Happireshipi.controllers;

import com.example.Happireshipi.services.HappireshipiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/", produces = "application/json")
@CrossOrigin(origins = "*")
public class HappireshipiController {

    private final HappireshipiService happireshipiService;

    public HappireshipiController(HappireshipiService happireshipiService) {
        this.happireshipiService = happireshipiService;
    }

    @GetMapping ("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Hello World!");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllMeals() {
        return happireshipiService.getAllMeals();
    }

    @GetMapping("/meal/{id}")
    public ResponseEntity<?> mealById(@PathVariable("id") Integer id) {
        return happireshipiService.mealById(id);
    }
}
