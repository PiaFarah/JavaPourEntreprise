package org.formation.dto;

import jakarta.validation.constraints.Positive;

public record CoffeeUpdateDto(
        //c un patch il peut ne pas y avoir de name
        String name,
        @Positive(message = "price should be positive") //on change int a INteger, comme si pas de prix ca met null pas 0
        Integer price) {

    }
