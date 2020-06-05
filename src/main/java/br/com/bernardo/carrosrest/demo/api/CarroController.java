package br.com.bernardo.carrosrest.demo.api;

import java.net.URI;
import java.util.List;

import br.com.bernardo.carrosrest.demo.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.bernardo.carrosrest.demo.domain.CarroEntity;
import br.com.bernardo.carrosrest.demo.service.CarroService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/carros")
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	@GetMapping()
	public ResponseEntity get() {
		return ResponseEntity.ok(carroService.getCarros());
		// ou: return new ResponseEntity<>(carroService.getCarros(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity getCarrosById(@PathVariable("id") Long id) {
		CarroDTO carroDTO = carroService.getCarroById(id);
		return ResponseEntity.ok(carroDTO);
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
	public ResponseEntity post(@RequestBody CarroEntity carroEntity) {

		try {
			CarroDTO carroDTO = carroService.insert(carroEntity);
			URI location = getUri(carroEntity.getId());
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
	public ResponseEntity put(@PathVariable("id") Long id, @RequestBody CarroEntity carroEntity) {
		carroEntity.setId(id);
		CarroDTO foundCarroEntity = carroService.update(carroEntity, id);
		return foundCarroEntity != null ?
				ResponseEntity.ok(foundCarroEntity) :
				ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		carroService.delete(id);
		return ResponseEntity.ok().build();
	}

}
