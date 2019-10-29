package com.robinette.recipe.services;

import com.robinette.recipe.commands.RecipeCommand;
import com.robinette.recipe.converters.RecipeCommandToRecipe;
import com.robinette.recipe.converters.RecipeToRecipeCommand;
import com.robinette.recipe.domain.Recipe;
import com.robinette.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {
    @Override
    public RecipeCommand saveRecipeCommand(RecipeCommand testRecipeCommand) {
        return null;
    }

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;
    public RecipeServiceImpl(RecipeRepository recipeRepository,
                             RecipeCommandToRecipe recipeCommandToRecipe,
                             RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getAllRecipes() {
        log.debug("RecipeServiceImpl.getAllRecipes()");
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe getRecipeById(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if(recipeOptional.isEmpty()) {
            throw new RuntimeException("Recipe not found: " + id);
        }
        return recipeOptional.get();
    }
}
