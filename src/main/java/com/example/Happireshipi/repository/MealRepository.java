package com.example.Happireshipi.repository;

import com.example.Happireshipi.dao.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {

    Optional<Meal> findById(Integer id);
}
