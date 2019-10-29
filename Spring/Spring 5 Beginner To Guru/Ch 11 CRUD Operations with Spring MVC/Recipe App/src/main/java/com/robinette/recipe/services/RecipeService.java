package com.robinette.recipe.services;

import com.robinette.recipe.model.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getAllRecipes();
    Recipe getRecipeById(Long id);
}
