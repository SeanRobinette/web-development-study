package com.robinette.recipe.services;

import com.robinette.recipe.model.Recipe;
import com.robinette.recipe.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {
    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getAllRecipes() {
        Recipe recipe = new Recipe();
        Set<Recipe> dummy = new HashSet<>();
        dummy.add(recipe);

        when(recipeRepository.findAll()).thenReturn(dummy);

        Set<Recipe> recipes = recipeService.getAllRecipes();
        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }
}