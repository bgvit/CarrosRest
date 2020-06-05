package br.com.bernardo.carrosrest.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.bernardo.carrosrest.demo.api.exception.ObjectNotFoundException;
import br.com.bernardo.carrosrest.demo.domain.CarroEntity;
import br.com.bernardo.carrosrest.demo.dto.CarroDTO;
import br.com.bernardo.carrosrest.demo.repository.CarroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;



@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;

	/*TODO: Como a minha aplicação irá manipular uma API externa. Exemplo: viacep RECEBER O CEP E TRANSFORMAR EM ENDEREÇO E ARMAZENAR NA BASE. NO RETORNO DO CLIENTE< RETORNTAR TANTO COM O CEP QUANTO ENDEREÇO*/

	public CarroDTO update(CarroEntity carro, Long id) {
		Assert.notNull(id,"Não foi possível atualizar o registro");

		// Busca o carro no banco de dados
		Optional<CarroEntity> foundCarroEntity = carroRepository.findById(id);
		if(foundCarroEntity.isPresent()) {
			CarroEntity carroEntity = foundCarroEntity.get();
			// Copiar as propriedades
			carroEntity.setNome(carro.getNome());
			carroEntity.setTipo(carro.getTipo());
			System.out.println("Carro id " + carroEntity.getId());

			// Atualiza o carro
			carroRepository.save(carroEntity);

			return CarroDTO.create(carroEntity);
		} else {
			return null;
			//throw new RuntimeException("Não foi possível atualizar o registro");
		}
	}

	public CarroDTO getCarroById(Long id) {
		Optional<CarroEntity> carroEntity = carroRepository.findById(id);
		return carroEntity.map(CarroDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
	}

	public List<CarroDTO> getCarros(){
		/*
		List<CarroDTO> list = rep.findAll().stream().map(CarroDTO::create).collect(Collectors.toList());
        return list;
		* */
		return carroRepository.findAll()
				.stream()
				.map(CarroDTO::create)
				.collect(Collectors.toList());
	}

	public List<CarroDTO> getCarrosByTipo(String tipo) {
		return carroRepository.findByTipo(tipo)
				.stream()
				.map(CarroDTO::create)
				.collect(Collectors.toList());
	}

	public CarroEntity save(CarroEntity carroEntity) {
		return carroRepository.save(carroEntity);
	}

	public CarroDTO insert(CarroEntity carroEntity) {
		Assert.isNull(carroEntity.getId(), "Não foi possível inserir o registro");
		return CarroDTO.create(carroRepository.save(carroEntity));
	}

	public void delete(Long id) {
		carroRepository.deleteById(id);
	}
}
