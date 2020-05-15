package br.com.bernardo.carrosrest.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.bernardo.carrosrest.demo.domain.Carro;
import br.com.bernardo.carrosrest.demo.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;



@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;

	public static Carro update(Carro carro, Long id) {
		Assert.notNull(id, "Não foi possível atualizar o registro");
		//Busca o carro no BD
		Optional<Carro> optional = getCarroById(id);
		if(optional.isPresent()) {
			Carro db = optional.get();
			db.setNome(carro.getNome());
			db.setTipo(carro.getTipo());
			System.out.println("Carro id " + db.getId());
			// Atualiza o carro
			carroRepository.save(db);
			return db;
		} else {
			throw new RuntimeException("Não foi possível atualizar o registro");
		}
		getCarroById(id).map(db -> {
			db.setNome(carro.getNome());
			db.setTipo(carro.getTipo());
			System.out.println("Carro id " + db.getId());

			carroRepository.save(db);
			return db;
		}).orElseThrow(() -> new RuntimeException("Não foi possível atualizar o registro"));
	}

	public Optional<Carro> getCarroById(Long id) {
		return carroRepository.findById(id);
	}

	public Iterable<Carro> getCarros(){
		return carroRepository.findAll();
	}

	public Iterable<Carro> getCarrosByTipo(String tipo) {
		return carroRepository.findByTipo(tipo);
	}

	public Carro save(Carro carro) {
		return carroRepository.save(carro);
	}

	public Carro insert(Carro carro) {
		Assert.isNull(carro.getId(), "Não foi possível inserir o registro");
		return carroRepository.save(carro);
	}
}
