package com.example.Happireshipi.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class DaoTests {



    @Test
    void mealClassConstructWithParameters() {
        // GIVEN
        Meal meal = new Meal(1,"Fondant", 200, "obiad", "Po pierwsze...", 20d, 3.2d, 10d);
        //when
        //then
        assertAll(() -> assertEquals(1, meal.getId()),
                () -> assertEquals("Fondant", meal.getName()),
                () -> assertEquals(200, meal.getPerPortionCalories()),
                () -> assertEquals("obiad", meal.getCategory()),
                () -> assertEquals("Po pierwsze...", meal.getRecipe()),
                () -> assertEquals(20d, meal.getProteins()),
                () -> assertEquals(3.2d, meal.getCarbohydrates()),
                () -> assertEquals(10d, meal.getFats()));
    }

    @Test
    void mealClassConstructNoneParametersOnlySetters() {
        // GIVEN
        Meal meal = new Meal();
        meal.setId(1);
        meal.setName("Fondant");
        meal.setPerPortionCalories(200);
        meal.setCategory("obiad");
        meal.setRecipe("Po pierwsze...");
        meal.setProteins(20d);
        meal.setCarbohydrates(3.2d);
        meal.setFats(10d);
        //when
        //then
        assertAll(() -> assertEquals(1, meal.getId()),
                () -> assertEquals("Fondant", meal.getName()),
                () -> assertEquals(200, meal.getPerPortionCalories()),
                () -> assertEquals("obiad", meal.getCategory()),
                () -> assertEquals("Po pierwsze...", meal.getRecipe()),
                () -> assertEquals(20d, meal.getProteins()),
                () -> assertEquals(3.2d, meal.getCarbohydrates()),
                () -> assertEquals(10d, meal.getFats()));
    }

}
