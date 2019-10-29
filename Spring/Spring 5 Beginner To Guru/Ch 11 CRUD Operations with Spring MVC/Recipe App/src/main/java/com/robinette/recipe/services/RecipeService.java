package com.robinette.recipe.services;

import com.robinette.recipe.commands.RecipeCommand;
import com.robinette.recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getAllRecipes();
    Recipe getRecipeById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand testRecipeCommand);
}
