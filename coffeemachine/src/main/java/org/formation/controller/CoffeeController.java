package org.formation.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.formation.dto.CoffeeCreateDto;
import org.formation.dto.CoffeeDto;
import org.formation.service.CoffeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("coffees")
public class CoffeeController {

    private final CoffeeService coffeeService;


    @PostMapping
    CoffeeDto createCoffee(@RequestBody @Valid CoffeeCreateDto dto) { //@valid permet dactiver les annotations de validation
        return coffeeService.createCoffee(dto);
    }


    @GetMapping
    List<CoffeeDto> coffees() {
        return coffeeService.allCoffees();
    }


    @GetMapping("{id}")
    ResponseEntity<CoffeeDto> coffee(@PathVariable Long id) {
        return coffeeService.oneCoffee(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
