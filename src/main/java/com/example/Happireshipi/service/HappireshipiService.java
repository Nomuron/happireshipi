package com.example.Happireshipi.service;

import com.example.Happireshipi.dao.*;
import com.example.Happireshipi.repository.MealRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
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

    @Override
    public List<ShoppingListElement> generateShoppingList(MealList mealList) {
        List<Meal> categorizedMeals = mealRepository.findAll();
        List<ShoppingListElement> ingredientList = new java.util.ArrayList<>(Collections.emptyList());
        boolean executed = false;

        for (Map<String, Integer> meal : mealList.getMealList()){
            System.out.println(meal.keySet());
            Float amountOfMeal = Float.parseFloat(String.valueOf(meal.values().iterator().next()));
            for (Meal mealName : categorizedMeals) {
                System.out.println(mealName.getName());
                if (meal.keySet().iterator().next().equals(mealName.getName())) {
                    System.out.println("dupa");
                    for (MealIngredient ingredient : mealName.getMealIngredients()) {
                        System.out.println();
//                        ingredientList.add(new ShoppingListElement(ingredient.getIngredient().getName(), ingredient.getAmount() * amountOfMeal, ingredient.getIngredient().getMeasure()));
//                        for (ShoppingListElement listElement : ingredientList) {
//                            System.out.println(ingredientList.contains(listElement));
//                        }
                        ingredientList.add(new ShoppingListElement(ingredient.getIngredient().getName(), ingredient.getAmount() * amountOfMeal, ingredient.getIngredient().getMeasure()));
//                        if (!executed) {
//                            ingredientList.add(new ShoppingListElement(ingredient.getIngredient().getName(), ingredient.getAmount() * amountOfMeal, ingredient.getIngredient().getMeasure()));
//                            executed = true;
//                        } else {
//                            for (ShoppingListElement listElement : ingredientList) {
//                                if (listElement.getName().equals(ingredient.getIngredient().getName())) {
//                                    listElement.setAmount(listElement.getAmount() + (ingredient.getAmount() * amountOfMeal));
//                                } else {
//                                    ingredientList.add(new ShoppingListElement(ingredient.getIngredient().getName(), ingredient.getAmount() * amountOfMeal, ingredient.getIngredient().getMeasure()));
//                                }
//                            }
//                        }
                    }
                }

            }
        }

        return ingredientList;
    }
}
