package com.robinette.recipe.model;

import com.robinette.recipe.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;

    @BeforeEach
    public void setup() {
        category = new Category();
    }

    @Test
    void getId() {
        Long idValue = 4L;

        category.setId(idValue);

        assertEquals(category.getId(), idValue);
    }

    @Test
    void getDescription() {
    }

    @Test
    void getRecipes() {
    }
}