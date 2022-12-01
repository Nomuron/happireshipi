package com.example.Happireshipi.service;

import com.example.Happireshipi.dao.Meal;
import com.example.Happireshipi.repository.MealRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HappireshipiService implements IHappireshipiService {

    private final MealRepository mealRepository;

    public HappireshipiService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public Optional<Meal> findById(Integer id) {
        return mealRepository.findById(id);
    }


}
