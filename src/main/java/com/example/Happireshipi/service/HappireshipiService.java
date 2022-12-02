package com.example.Happireshipi.service;

import com.example.Happireshipi.dao.Ingredient;
import com.example.Happireshipi.dao.Meal;
import com.example.Happireshipi.repository.IngredientRepository;
import com.example.Happireshipi.repository.MealRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HappireshipiService implements IHappireshipiService {

    private final MealRepository mealRepository;
    private final IngredientRepository ingredientRepository;

    public HappireshipiService(MealRepository mealRepository, IngredientRepository ingredientRepository) {
        this.mealRepository = mealRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Optional<Meal> mealFindById(Integer id) {
        return mealRepository.findById(id);
    }

    @Override
    public List<Meal> mealFindAll() {
        return mealRepository.findAll();
    }

    @Override
    public Optional<Ingredient> ingredientFindById(Integer id) {
        return ingredientRepository.findById(id);
    }
}
