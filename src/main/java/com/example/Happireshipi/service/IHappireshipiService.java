package com.example.Happireshipi.service;
import com.example.Happireshipi.dao.Meal;
import com.example.Happireshipi.dao.ShoppingListElement;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IHappireshipiService {
    Optional<Meal> mealFindById(Integer id);

    List<Meal> mealFindAll();

    List<Meal> mealByCategory(String category);

//    List<ShoppingListElement> generateShoppingList(List<Map<String, Integer>> mealList);
}
