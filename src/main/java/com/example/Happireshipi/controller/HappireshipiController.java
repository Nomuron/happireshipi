package com.example.Happireshipi.controller;

import com.example.Happireshipi.dao.Meal;
import com.example.Happireshipi.dao.ShoppingListElement;
import com.example.Happireshipi.service.IHappireshipiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HappireshipiController {

    private final IHappireshipiService happireshipiService;

    public HappireshipiController(IHappireshipiService happireshipiService) {
        this.happireshipiService = happireshipiService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello world!";
    }

    @GetMapping("/meal/{id}")
    public ResponseEntity<Meal> findMealById(@PathVariable Integer id) {
        return ResponseEntity.of(happireshipiService.mealFindById(id));
    }

    @GetMapping("/meal/all")
    public ResponseEntity<List<Meal>> findAllMeals() {
        return ResponseEntity.ok(happireshipiService.mealFindAll());
    }

    @GetMapping("/meal/sort/{category}")
    public ResponseEntity<List<Meal>> findAllByCategory(@PathVariable("category") String category) {
        return ResponseEntity.ok(happireshipiService.mealByCategory(category));
    }

//    @PostMapping("/list")
//    public ResponseEntity<List<ShoppingListElement>> generateList(@RequestBody List<Map<String, Integer>> mealList) {
//        return ResponseEntity.ok(happireshipiService.generateShoppingList(mealList));
//    }
}
