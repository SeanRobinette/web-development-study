package com.robinette.recipe.repositories;

import com.robinette.recipe.model.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByDescription() {
        Optional<UnitOfMeasure> teaspoonUom = unitOfMeasureRepository.findByDescription("Teaspoon");

        assertEquals(teaspoonUom.get().getDescription(), "Teaspoon");
    }

    @Test
    void findByDescriptionCup() {
        Optional<UnitOfMeasure> teaspoonUom = unitOfMeasureRepository.findByDescription("Cup");

        assertEquals(teaspoonUom.get().getDescription(), "Cup");
    }
}