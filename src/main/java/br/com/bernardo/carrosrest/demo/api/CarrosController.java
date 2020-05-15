package br.com.bernardo.carrosrest.demo.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.bernardo.carrosrest.demo.domain.Carro;
import br.com.bernardo.carrosrest.demo.service.CarroService;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {
	
	@Autowired
	private CarroService carroService;
	
	@GetMapping()
	public Iterable<Carro> get() {
		return carroService.getCarros();
	}

	@GetMapping("/{id}")
	public Optional<Carro> getCarrosById(@PathVariable("id") Long id) {
		return carroService.getCarroById(id);
	}

	@GetMapping("/tipo/{tipo}")
	public Iterable<Carro> getCarrosByTipo(@PathVariable("tipo") String tipo) {
		return carroService.getCarrosByTipo(tipo);
	}
	@PostMapping
	public String post(@RequestBody Carro carro) {
		Carro c = carroService.insert(carro);
		return "Carro salvo com sucesso: " + c.getId();
	}

	@PutMapping("/{id}")
	public String put(@PathVariable("id") Long id, @RequestBody Carro carro) {
		Carro c = CarroService.update(carro, id);
		return "Carro atualizado com sucesso: " + c.getId();

	}
}
