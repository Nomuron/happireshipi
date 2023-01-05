package com.example.Happireshipi.service;

import com.example.Happireshipi.dao.Meal;
import com.example.Happireshipi.repository.MealRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HappireshipiServiceTest {

    @Mock
    private MealRepository mealRepository;

    @InjectMocks
    private HappireshipiService happireshipiService;

    @Test
    void isMealAllNotEmpty() {
        when(mealRepository.findAll()).thenReturn(List.of(new Meal()));

        List<Meal> all = happireshipiService.mealFindAll();

        assertThat(all).isNotEmpty();
    }

    @Test
    void isMealAllEmpty() {
        when(mealRepository.findAll()).thenReturn(Collections.emptyList());

        List<Meal> all = happireshipiService.mealFindAll();

        assertThat(all).isEmpty();
    }

    @Test
    void isMealByCategoryNotEmpty() {
        when(mealRepository.findAll()).thenReturn(List.of(new Meal()));

        List<Meal> all = happireshipiService.mealFindAll();

        assertThat(all).isNotEmpty();
    }

    @Test
    void isMealByCategoryEmpty() {
        when(mealRepository.findAll()).thenReturn(Collections.emptyList());

        List<Meal> all = happireshipiService.mealFindAll();

        assertThat(all).isEmpty();
    }
}
