package com.robinette.recipe.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
@NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure unitOfMeasure;
    private String description;

    @ManyToOne
    private Recipe recipe;

    public Ingredient(BigDecimal amount, UnitOfMeasure unitOfMeasure, String description) {
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
        this.description = description;
    }

}
