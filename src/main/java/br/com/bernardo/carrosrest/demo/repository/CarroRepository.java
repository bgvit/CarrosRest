package br.com.bernardo.carrosrest.demo.repository;

import br.com.bernardo.carrosrest.demo.domain.CarroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<CarroEntity, Long> {
    List<CarroEntity> findByTipo(String tipo);
}
