package br.com.bernardo.carros.repository;

import br.com.bernardo.carros.domain.Carro;
import org.springframework.data.repository.CrudRepository;

public interface CarroRepository extends CrudRepository<Carro, Long> {
}
