package br.com.bernardo.carrosrest.demo.mapper;

import br.com.bernardo.carrosrest.demo.domain.Carro;
import br.com.bernardo.carrosrest.demo.dto.CarroDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-29T15:02:59-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_252 (Private Build)"
)
@Component
public class CarroMapperImpl implements CarroMapper {

    @Override
    public CarroDTO toCarroDTO(Carro carro) {
        if ( carro == null ) {
            return null;
        }

        CarroDTO carroDTO = new CarroDTO();

        carroDTO.setId( carro.getId() );
        carroDTO.setNome( carro.getNome() );
        carroDTO.setTipo( carro.getTipo() );

        return carroDTO;
    }

    @Override
    public Carro toCarro(CarroDTO carroDTO) {
        if ( carroDTO == null ) {
            return null;
        }

        Carro carro = new Carro();

        carro.setId( carroDTO.getId() );
        carro.setNome( carroDTO.getNome() );
        carro.setTipo( carroDTO.getTipo() );

        return carro;
    }
}
