package br.com.bernardo.carrosrest.demo.mapper;

import br.com.bernardo.carrosrest.demo.domain.CarroEntity;
import br.com.bernardo.carrosrest.demo.dto.CarroDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-05T10:44:52-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_252 (Private Build)"
)
@Component
public class CarroMapperImpl implements CarroMapper {

    @Override
    public CarroDTO toCarroDTO(CarroEntity carroEntity) {
        if ( carroEntity == null ) {
            return null;
        }

        CarroDTO carroDTO = new CarroDTO();

        carroDTO.setId( carroEntity.getId() );
        carroDTO.setNome( carroEntity.getNome() );
        carroDTO.setTipo( carroEntity.getTipo() );

        return carroDTO;
    }

    @Override
    public CarroEntity toCarroEntity(CarroDTO carroDTO) {
        if ( carroDTO == null ) {
            return null;
        }

        CarroEntity carroEntity = new CarroEntity();

        carroEntity.setId( carroDTO.getId() );
        carroEntity.setNome( carroDTO.getNome() );
        carroEntity.setTipo( carroDTO.getTipo() );

        return carroEntity;
    }
}
