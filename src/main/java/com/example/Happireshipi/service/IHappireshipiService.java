package com.example.Happireshipi.service;

import com.example.Happireshipi.dao.Ingredient;
import com.example.Happireshipi.dao.Meal;

import java.util.List;
import java.util.Optional;

public interface IHappireshipiService {
    Optional<Meal> mealFindById(Integer id);

    List<Meal> mealFindAll();

    Optional<Ingredient> ingredientFindById(Integer id);
}
