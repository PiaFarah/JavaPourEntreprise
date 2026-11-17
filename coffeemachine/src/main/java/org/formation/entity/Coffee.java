package org.formation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data //generer tostring getter setter etc
public class Coffee {

    @Id
    @GeneratedValue //demander a la base de donnee dincrementer elle meme
    private Long id;
    @NotBlank(message = "Coffee name cannot be null")
    private String name;
    @Positive(message = "price should be positive")
    private int price;


    public Coffee(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
