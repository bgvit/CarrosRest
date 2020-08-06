package br.com.bernardo.carrosrest.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.bernardo.carrosrest.demo.api.exception.ObjectNotFoundException;
import br.com.bernardo.carrosrest.demo.domain.CarroEntity;
import br.com.bernardo.carrosrest.demo.dto.CarroDTO;
import br.com.bernardo.carrosrest.demo.mapper.CarroMapper;
import br.com.bernardo.carrosrest.demo.repository.CarroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;



@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;

	@Autowired
	CarroMapper carroMapper;

	public CarroDTO update(CarroDTO carro, Long id) {
		Assert.notNull(id,"Não foi possível atualizar o registro");
		// Busca o carro no banco de dados
		Optional<CarroEntity> carroEntityOptional = carroRepository.findById(id);
		if(carroEntityOptional.isPresent()) {
			CarroEntity carroEntityToBeUpdated = carroEntityOptional.get();
			System.out.println("Carro id " + carroEntityToBeUpdated.getId());
			fillCarroEntityToBeUpdated(carroEntityToBeUpdated, carro);
			// Atualiza o carro
			carroRepository.save(carroEntityToBeUpdated);
			return carroMapper.toCarroDTO(carroEntityToBeUpdated);
		} else {
			return null;
		}
	}

	public CarroDTO getCarroById(Long id) {
		Optional<CarroEntity> carroEntity = carroRepository.findById(id);
		return carroEntity.map(ce -> carroMapper.toCarroDTO(ce)).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
	}

	public List<CarroDTO> getCarros(){
		return carroRepository.findAll()
				.stream()
				.map(ce -> carroMapper.toCarroDTO(ce))
				.collect(Collectors.toList());
	}

	public List<CarroDTO> getCarrosByTipo(String tipo) {
		return carroRepository.findByTipo(tipo)
				.stream()
				.map(ce -> carroMapper.toCarroDTO(ce))
				.collect(Collectors.toList());
	}

	public CarroEntity save(CarroDTO carroDTO) {
		CarroEntity carroEntity = carroMapper.toCarroEntity(carroDTO);
		return carroRepository.save(carroEntity);
	}

	public CarroDTO insert(CarroDTO carroDTO) {
		Assert.isNull(carroDTO.getId(), "Não foi possível inserir o registro");
		CarroEntity carroEntity = carroMapper.toCarroEntity(carroDTO);
		carroEntity.setDate();
		CarroEntity carroPersistedEntity = carroRepository.save(carroEntity);
		CarroDTO carroPersistedDTO = carroMapper.toCarroDTO(carroPersistedEntity);
		return carroPersistedDTO;
	}

	public void delete(Long id) {
		carroRepository.deleteById(id);
	}

	public void fillCarroEntityToBeUpdated(CarroEntity carroEntity, CarroDTO carroDTO) {
		// Copiar as propriedades - poucos elementos somente para teste
		carroEntity.setNome(carroDTO.getNome());
		carroEntity.setTipo(carroDTO.getTipo());
		carroEntity.setCarOwner(carroDTO.getCarOwner());
//		carroEntity.setCarroColor(carroDTO.getCarroColor());
	}
}
