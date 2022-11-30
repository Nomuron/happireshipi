package com.example.Happireshipi.dao;

import com.example.Happireshipi.repository.MealRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DaoTests {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    MealRepository mealRepository;


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

    @Test
    void whenMealFindById_thenReturnMeal() {
        // given
        Meal meal = new Meal();
        meal.setId(1);
        meal.setName("Fondant czekoladowy");
        meal.setPerPortionCalories(600);

        // when
        Optional<Meal> found = mealRepository.findById(meal.getId());

        // then
        assertThat(found.get().getId())
                .isEqualTo(meal.getId());
    }
}
