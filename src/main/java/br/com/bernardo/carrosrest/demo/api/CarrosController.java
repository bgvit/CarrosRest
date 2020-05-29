package br.com.bernardo.carrosrest.demo.api;

import java.util.List;
import java.util.Optional;

import br.com.bernardo.carrosrest.demo.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.bernardo.carrosrest.demo.domain.Carro;
import br.com.bernardo.carrosrest.demo.service.CarroService;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {
	
	@Autowired
	private CarroService carroService;
	
	@GetMapping()
	public ResponseEntity get() {
		return ResponseEntity.ok(carroService.getCarros());
		// ou: return new ResponseEntity<>(carroService.getCarros(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity getCarrosById(@PathVariable("id") Long id) {
		Optional<CarroDTO> carro = carroService.getCarroById(id);
		return carro.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/tipo/{tipo}")
	public ResponseEntity getCarrosByTipo(@PathVariable("tipo") String tipo) {
		List<CarroDTO> carros = carroService.getCarrosByTipo(tipo);
		return carros.isEmpty() ?
				ResponseEntity.noContent().build() :
				ResponseEntity.ok(carros);
	}
	/*Nomenclatura das variáveis, retornar JSON - testar, fazer um exceptionhandler*/
	@PostMapping
	public String post(@RequestBody Carro carro) {
		Carro c = carroService.insert(carro);
		return "Carro salvo com sucesso: " + c.getId();
	}

	@PutMapping("/{id}")
	public String put(@PathVariable("id") Long id, @RequestBody Carro carro) {
		Carro c = carroService.update(carro, id);
		return "Carro atualizado com sucesso: " + c.getId();
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		carroService.delete(id);
		return "Carro deletado com sucesso.";
	}

}
