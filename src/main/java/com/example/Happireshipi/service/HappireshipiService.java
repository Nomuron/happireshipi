package com.example.Happireshipi.service;

import com.example.Happireshipi.dao.Meal;
import com.example.Happireshipi.repository.MealRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HappireshipiService implements IHappireshipiService {

    private final MealRepository mealRepository;

    public HappireshipiService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
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
    public List<Meal> mealByCategory(String category) {
        List<Meal> categorizedMeals = mealRepository.findAll();
        categorizedMeals.removeIf(meal -> !meal.getCategory().equals(category));
        return categorizedMeals;
    }
}
