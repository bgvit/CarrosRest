package br.com.bernardo.carros.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bernardo.carros.domain.Carro;
import br.com.bernardo.carros.service.CarroService;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {
	
	@Autowired
	private CarroService carroService;
	
	@GetMapping()
	public Iterable<Carro> get() {
		return carroService.getCarros();
	}
	
}
