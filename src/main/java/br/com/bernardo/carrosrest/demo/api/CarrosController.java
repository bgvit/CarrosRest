package br.com.bernardo.carrosrest.demo.api;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import br.com.bernardo.carrosrest.demo.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.bernardo.carrosrest.demo.domain.Carro;
import br.com.bernardo.carrosrest.demo.service.CarroService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity post(@RequestBody Carro carro) {

		try {
			CarroDTO carroDTO = carroService.insert(carro);
			URI location = getUri(carro.getId());
			return ResponseEntity.created(location).build();
		} catch (Exception exception) {
			return ResponseEntity.badRequest().build();
		}
	}

	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand((id)).toUri();
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
