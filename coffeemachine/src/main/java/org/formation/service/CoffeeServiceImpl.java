package org.formation.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.formation.dto.CoffeeCreateDto;
import org.formation.dto.CoffeeDto;
import org.formation.entity.Coffee;
import org.formation.mapper.CoffeeMapper;
import org.formation.repository.CoffeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository repository;
    private final CoffeeMapper mapper;


    @PostConstruct // des que le bean est cree, execute cette methode
    void initDB()
    {
        repository.saveAll(List.of(
                new Coffee("Espresso", 98),
                new Coffee("latte coffee", 76),
                new Coffee("Robusta", 54)
        ));
    }

    @Override
    public List<CoffeeDto> allCoffees() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public Optional<CoffeeDto> oneCoffee(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Override
    public CoffeeDto createCoffee(CoffeeCreateDto dto) {
        Coffee entity = mapper.toEntity(dto);
        Coffee saved = repository.save(entity); //sauvegarde et retourne objet de type coffee avec id
        return  mapper.toDto(saved) ;
    }


    @Override
    public CoffeeDto updateCoffee(CoffeeDto coffeeDto) {
        return null;
    }
}
