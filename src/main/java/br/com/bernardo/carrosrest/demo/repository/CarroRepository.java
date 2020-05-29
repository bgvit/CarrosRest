package br.com.bernardo.carrosrest.demo.repository;

import br.com.bernardo.carrosrest.demo.domain.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findByTipo(String tipo);
}
