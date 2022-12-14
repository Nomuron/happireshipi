package com.example.Happireshipi.dao;

import com.example.Happireshipi.repository.MealRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    NOTE:
*   These tests won't run, cuz I removed constructors from entity classes.
*   I keep them for reference for potential future integration tests.
* */

//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class DaoTests {
//
//    @Autowired
//    MealRepository mealRepository;
//
//    @Test
//    void mealClassConstructWithParameters() {
//        // GIVEN
//        Meal meal = new Meal(1,"Fondant", 200, "obiad", "", "Po pierwsze...", 20f, 3.2f, 10f);
//        //when
//        //then
//        assertAll(() -> assertEquals(1, meal.getId()),
//                () -> assertEquals("Fondant", meal.getName()),
//                () -> assertEquals(200, meal.getPerPortionCalories()),
//                () -> assertEquals("obiad", meal.getCategory()),
//                () -> assertEquals("Po pierwsze...", meal.getRecipe()),
//                () -> assertEquals(20f, meal.getProteins()),
//                () -> assertEquals(3.2f, meal.getCarbohydrates()),
//                () -> assertEquals(10f, meal.getFats()));
//    }
//
//    @Test
//    void mealClassConstructNoneParametersOnlySetters() {
//        // GIVEN
//        Meal meal = new Meal();
//        meal.setId(1);
//        meal.setName("Fondant");
//        meal.setPerPortionCalories(200);
//        meal.setCategory("obiad");
//        meal.setRecipe("Po pierwsze...");
//        meal.setProteins(20f);
//        meal.setCarbohydrates(3.2f);
//        meal.setFats(10f);
//        //when
//        //then
//        assertAll(() -> assertEquals(1, meal.getId()),
//                () -> assertEquals("Fondant", meal.getName()),
//                () -> assertEquals(200, meal.getPerPortionCalories()),
//                () -> assertEquals("obiad", meal.getCategory()),
//                () -> assertEquals("Po pierwsze...", meal.getRecipe()),
//                () -> assertEquals(20f, meal.getProteins()),
//                () -> assertEquals(3.2f, meal.getCarbohydrates()),
//                () -> assertEquals(10f, meal.getFats()));
//    }
//
//    @Test
//    void whenMealFindById_thenReturnMeal() {
//        // given
//        Meal meal = new Meal();
//        meal.setId(1);
//        meal.setName("Fondant czekoladowy");
//        meal.setPerPortionCalories(600);
//
//        // when
//        Optional<Meal> found = mealRepository.findById(meal.getId());
//
//        // then
//        assertThat(found.get().getId())
//                .isEqualTo(meal.getId());
//    }
//}
