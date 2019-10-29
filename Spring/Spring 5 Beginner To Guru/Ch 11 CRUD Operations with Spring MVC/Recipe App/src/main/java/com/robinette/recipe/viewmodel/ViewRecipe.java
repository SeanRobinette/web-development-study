package com.robinette.recipe.viewmodel;

import com.robinette.recipe.model.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ViewRecipe {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Set<ViewIngredient> ingredients = new HashSet<>();
    private Difficulty difficulty;
    private ViewNotes notes;
    private Set<ViewCategory> categories = new HashSet<>();
}
