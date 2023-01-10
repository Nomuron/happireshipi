package com.example.Happireshipi.dao;

import java.util.List;
import java.util.Map;

public class MealList {

    private List<Map<String, Integer>> mealList;

    public MealList(List<Map<String, Integer>> mealList) {
        this.mealList = mealList;
    }

    public MealList() {
    }

    public List<Map<String, Integer>> getMealList() {
        return mealList;
    }

    public void setMealList(List<Map<String, Integer>> mealList) {
        this.mealList = mealList;
    }
}
