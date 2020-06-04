package br.com.bernardo.carrosrest.demo.mapper;

import br.com.bernardo.carrosrest.demo.domain.CarroEntity;
import br.com.bernardo.carrosrest.demo.dto.CarroDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarroMapper {
    CarroDTO toCarroDTO(CarroEntity carroEntity);
    CarroEntity toCarroEntity(CarroDTO carroDTO);
}
