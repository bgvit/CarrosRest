package br.com.bernardo.carros.service;

import java.util.ArrayList;
import java.util.List;

import br.com.bernardo.carros.domain.Carro;
import br.com.bernardo.carros.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;

	public Iterable<Carro> getCarros(){
		return carroRepository.findAll();
	}

	public List<Carro> getCarrosFake(){
		List<Carro> carros = new ArrayList<>();
		
		carros.add(new Carro(1L,"Fusca"));
		carros.add(new Carro(2L,"Brasilia"));
		carros.add(new Carro(2L,"Chevette"));
		
		return carros;
	}
}
