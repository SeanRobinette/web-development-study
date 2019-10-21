package com.robinette.recipe.bootstrap;


import com.robinette.recipe.model.*;
import com.robinette.recipe.repositories.CategoryRepository;
import com.robinette.recipe.repositories.RecipeRepository;
import com.robinette.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;


@Component
public class DataLoader implements CommandLineRunner {
    private final UnitOfMeasureRepository uomRepository;
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private Map<String, UnitOfMeasure> uomMap;
    private Map<String, Category> categoryMap;

    public DataLoader(UnitOfMeasureRepository uomRepository, CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
        this.uomRepository = uomRepository;
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        recipeRepository.saveAll(getRecipeList());
    }

    private List<Recipe> getRecipeList() {
        // Load UnitOfMeasures
        uomMap = new HashMap<>();
        String[] uomNames = {
            "Each",
            "Teaspoon",
            "Tablespoon",
            "Cup",
            "Pinch",
            "Dash",
            "Ounce"
        };
        for(String uomName : uomNames) {
            Optional<UnitOfMeasure> uom = uomRepository.findByDescription(uomName);
            if(uom.isEmpty()) {
                throw new RuntimeException("Expected UnitOfMeasure not found: " + uomName);
            } else {
                uomMap.put(uomName, uom.get());
            }
        }

        // Load Categories
        categoryMap = new HashMap<>();
        String[] categoryNames = {
            "American",
            "Mexican"
        };
        for(String categoryName : categoryNames) {
            Optional<Category> cat = categoryRepository.findByDescription(categoryName);
            if(cat.isEmpty()) {
                throw new RuntimeException("Expected UnitOfMeasure not found: " + categoryName);
            } else {
                categoryMap.put(categoryName, cat.get());
            }
        }

        // Initialize the list itself
        List<Recipe> list = new ArrayList<>();

        // Perfect Guacamole recipe
        Recipe guacamole = new Recipe();
        guacamole.setDescription("Perfect Guacamole");
        guacamole.setPrepTime(10);
        guacamole.setCookTime(0);
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setServings(3);
        guacamole.setSource("");
        guacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamole.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.");
        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("Variations\n" +
                "\n" +
                "For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" +
                "\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "For a deviled egg version with guacamole, try our Guacamole Deviled Eggs!");
        guacamole.setNotes(guacNotes);
        guacNotes.setRecipe(guacamole);
        guacamole.getCategories().add(categoryMap.get("Mexican"));
        guacamole.getCategories().add(categoryMap.get("American"));
        guacamole.getIngredients().add(new Ingredient(new BigDecimal(2), uomMap.get("Each"), "ripe avocados", guacamole));
        guacamole.getIngredients().add(new Ingredient(new BigDecimal(0.5), uomMap.get("Teaspoon"), "Kosher salt", guacamole));
        guacamole.getIngredients().add(new Ingredient(new BigDecimal(1), uomMap.get("Tablespoon"), "fresh lime juice or lemon juice", guacamole));
        guacamole.getIngredients().add(new Ingredient(new BigDecimal(2), uomMap.get("Tablespoon"), "minced red onion or thinly sliced green onion", guacamole));
        guacamole.getIngredients().add(new Ingredient(new BigDecimal(1.5), uomMap.get("Each"), "serrano chiles, stems and seeds removed, minced", guacamole));
        guacamole.getIngredients().add(new Ingredient(new BigDecimal(2), uomMap.get("Tablespoon"), "cilantro (leaves and tender stems), finely chopped", guacamole));
        guacamole.getIngredients().add(new Ingredient(new BigDecimal(1), uomMap.get("Dash"), "freshly grated black pepper", guacamole));
        guacamole.getIngredients().add(new Ingredient(new BigDecimal(0.5), uomMap.get("Each"), "ripe tomato, seeds and pulp removed, chopped", guacamole));
        list.add(guacamole);

        // Spicy Grilled Chicken Tacos
        Recipe tacoRecipe = new Recipe();
        tacoRecipe.setDescription("Spicy Grilled Chicken Tacos");
        tacoRecipe.setPrepTime(20);
        tacoRecipe.setCookTime(15);
        tacoRecipe.setDifficulty(Difficulty.MEDIUM);
        tacoRecipe.setServings(5);
        tacoRecipe.setSource("");
        tacoRecipe.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        tacoRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "Spicy Grilled Chicken Tacos\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");
        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!");
        tacoRecipe.setNotes(tacoNotes);
        tacoNotes.setRecipe(tacoRecipe);
        tacoRecipe.getCategories().add(categoryMap.get("Mexican"));
        tacoRecipe.getIngredients().add(new Ingredient(new BigDecimal(2), uomMap.get("Tablespoon"), "ancho chili powder", tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient(new BigDecimal(1), uomMap.get("Teaspoon"), "teaspoon dried oregano", tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient(new BigDecimal(1), uomMap.get("Teaspoon"), "dried cumin", tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient(new BigDecimal(1), uomMap.get("Teaspoon"), "sugar", tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient(new BigDecimal(1/2), uomMap.get("Teaspoon"), "salt", tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient(new BigDecimal(1), uomMap.get("Each"), "clove garlic, finely chopped", tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient(new BigDecimal(1), uomMap.get("Tablespoon"), "finely grated orange zest", tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient(new BigDecimal(3), uomMap.get("Tablespoon"), "fresh-squeezed orange juice", tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient(new BigDecimal(2), uomMap.get("Tablespoon"), "olive oil", tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient(new BigDecimal(5), uomMap.get("Each"), "skinless, boneless chicken thighs (1 1/4 pounds)", tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient(new BigDecimal(8), uomMap.get("Each"), "small corn tortillas", tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient(new BigDecimal(3), uomMap.get("Cup"), "packed baby arugula (3 ounces)", tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient(new BigDecimal(2), uomMap.get("Each"), "medium ripe avocados, sliced", tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient(new BigDecimal(4), uomMap.get("Each"), "radishes, thinly sliced", tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient(new BigDecimal(1/2), uomMap.get("Pint"), "cherry tomatoes, halved", tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient(new BigDecimal(1/4), uomMap.get("Each"), "red onion, thinly sliced", tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient(new BigDecimal(1), uomMap.get("Each"), "Roughly chopped cilantro", tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient(new BigDecimal(1/2), uomMap.get("Cup"), "sour cream thinned with 1/4 cup milk", tacoRecipe));
        tacoRecipe.getIngredients().add(new Ingredient(new BigDecimal(1), uomMap.get("Each"), "lime, cut into wedges", tacoRecipe));
        list.add(tacoRecipe);

        return list;
    }
}
