package com.robinette.recipe.controllers;

import com.robinette.recipe.model.Category;
import com.robinette.recipe.model.UnitOfMeasure;
import com.robinette.recipe.repositories.CategoryRepository;
import com.robinette.recipe.repositories.UnitOfMeasureRepository;
import com.robinette.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String index(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "index";
    }
}
