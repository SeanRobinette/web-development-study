package com.robinette.recipe.viewmodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ViewIngredient {
    private Long id;
    private String description;
    private BigDecimal amount;
    private ViewUnitOfMeasure unitOfMeasure;
}
