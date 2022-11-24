package com.example.Happireshipi.services;

import com.example.Happireshipi.model.Meal;
import com.example.Happireshipi.repository.MealRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class HappireshipiService {

    private final MealRepository mealRepository;

    public HappireshipiService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }


    public ResponseEntity<?> getAllMeals() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        List<Meal> mealList = mealRepository.findAll();
        if(!mealList.isEmpty()) {
            map.put("status", 1);
            map.put("data", mealList);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "Data is not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> mealById(Integer id) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        try {
            Meal meal = mealRepository.findById(id).get();
            map.put("status", 1);
            map.put("data", meal);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception ex) {
            map.clear();
            map.put("status", 0);
            map.put("message", "Data not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    //old
//    public ResponseEntity<?> mealById(Integer id) {
//        return mealRepository.findById(id).
//                map(ResponseEntity::ok).
//                orElseGet(() -> ResponseEntity.notFound().build());
//    }
}
