package org.formation.mapper;

import org.formation.dto.CoffeeCreateDto;
import org.formation.dto.CoffeeDto;
import org.formation.entity.Coffee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CoffeeMapper {
    CoffeeDto toDto(Coffee coffee);

    @Mapping(target = "id",ignore = true) //ne cree pas derreur si tu ne trouves pas lid car le dto na pas id
    Coffee toEntity(CoffeeCreateDto dto);


}
