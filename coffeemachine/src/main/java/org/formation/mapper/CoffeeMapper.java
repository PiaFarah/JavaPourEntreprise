package org.formation.mapper;

import org.formation.dto.CoffeeCreateDto;
import org.formation.dto.CoffeeDto;
import org.formation.dto.CoffeeUpdateDto;
import org.formation.entity.Coffee;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CoffeeMapper {
    CoffeeDto toDto(Coffee coffee);

    @Mapping(target = "id", ignore = true)
        //ne cree pas derreur si tu ne trouves pas lid car le dto na pas id
    Coffee toEntity(CoffeeCreateDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE) //si le prix ou le name est null il ecrasera pas lancien prix/name
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Coffee entity, CoffeeUpdateDto dto);

}
