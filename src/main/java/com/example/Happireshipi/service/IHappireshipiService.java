package com.example.Happireshipi.service;

import com.example.Happireshipi.dao.Meal;

import java.util.List;
import java.util.Optional;

public interface IHappireshipiService {
    Optional<Meal> findById(Integer id);

    List<Meal> findAll();
}
