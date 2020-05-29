package br.com.bernardo.carrosrest.demo.mapper;

import br.com.bernardo.carrosrest.demo.domain.Carro;
import br.com.bernardo.carrosrest.demo.dto.CarroDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarroDTO toCarroDTO(Carro carro);
    Carro toCarro(CarroDTO carroDTO);
}
