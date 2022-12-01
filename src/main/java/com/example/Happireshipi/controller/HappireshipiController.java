package com.example.Happireshipi.controller;

import com.example.Happireshipi.dao.Meal;
import com.example.Happireshipi.service.IHappireshipiService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
    public Meal findMealById(@PathVariable Integer id) {
        Meal entity = happireshipiService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return entity;
    }
}
