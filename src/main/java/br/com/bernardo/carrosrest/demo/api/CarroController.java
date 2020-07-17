package br.com.bernardo.carrosrest.demo.api;

import java.util.List;

import br.com.bernardo.carrosrest.demo.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.bernardo.carrosrest.demo.domain.CarroEntity;
import br.com.bernardo.carrosrest.demo.service.CarroService;

@RestController
@RequestMapping("/api/v1/carros")
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	@GetMapping()
	@ResponseStatus(HttpStatus.ACCEPTED)
	public List<CarroDTO> get() {
		return carroService.getCarros();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public CarroDTO getCarrosById(@PathVariable("id") Long id) {
		CarroDTO carroDTO = carroService.getCarroById(id);
		return carroDTO;
	}

	@GetMapping("/tipo/{tipo}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public List<CarroDTO> getCarrosByTipo(@PathVariable("tipo") String tipo) {
		List<CarroDTO> carros = carroService.getCarrosByTipo(tipo);
		return carros;
	}
	/*Modo de fazer sugerido pelo Mauricio em que você devolve o objeto na requisição
	* TODO: Alterar os outros para enviar objeto na requisição*/

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public CarroDTO post(@RequestBody CarroEntity carroEntity) {
		CarroDTO carroDTO = carroService.insert(carroEntity);
		return carroDTO;
	}

	@PutMapping("/{id}")
	public CarroDTO put(@PathVariable("id") Long id, @RequestBody CarroEntity carroEntity) {
		carroEntity.setId(id);
		CarroDTO foundCarroEntity = carroService.update(carroEntity, id);
		return foundCarroEntity;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		carroService.delete(id);
		return ResponseEntity.ok().build();
	}

}
