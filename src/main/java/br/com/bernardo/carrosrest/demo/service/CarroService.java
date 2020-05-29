package br.com.bernardo.carrosrest.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.bernardo.carrosrest.demo.domain.Carro;
import br.com.bernardo.carrosrest.demo.dto.CarroDTO;
import br.com.bernardo.carrosrest.demo.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;



@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;

/*	public Carro update(Carro carro, Long id) {
		Assert.notNull(id, "Não foi possível atualizar o registro");
		//Busca o carro no BD
		Optional<Carro> optional = getCarroById(id);
		if(optional.isPresent()) {
			Carro carFromDB = optional.get();
			carFromDB.setNome(carro.getNome());
			carFromDB.setTipo(carro.getTipo());
			System.out.println("Carro id " + carFromDB.getId());
			// Atualiza o carro
			carroRepository.save(carFromDB);
			return carFromDB;
		} else {
			throw new RuntimeException("Não foi possível atualizar o registro");
		}*/
		/*getCarroById(id).map(db -> {
			db.setNome(carro.getNome());
			db.setTipo(carro.getTipo());
			System.out.println("Carro id " + db.getId());

			carroRepository.save(db);
			return db;
		}).orElseThrow(() -> new RuntimeException("Não foi possível atualizar o registro"));*/

	public Optional<CarroDTO> getCarroById(Long id) {
		return carroRepository.findById(id).map(CarroDTO::new);
	}

	public List<CarroDTO> getCarros(){
		return carroRepository.findAll()
				.stream()
				.map(CarroDTO::new)
				.collect(Collectors.toList());
	}

	public List<CarroDTO> getCarrosByTipo(String tipo) {
		return carroRepository.findByTipo(tipo)
				.stream()
				.map(CarroDTO::new)
				.collect(Collectors.toList());
	}

	public Carro save(Carro carro) {
		return carroRepository.save(carro);
	}

	public CarroDTO insert(Carro carro) {
		Assert.isNull(carro.getId(), "Não foi possível inserir o registro");
		return CarroDTO.create(carroRepository.save(carro));
	}

	public void delete(Long id) {
		if(getCarroById(id).isPresent()) {
			carroRepository.deleteById(id);
		}
	}
}
