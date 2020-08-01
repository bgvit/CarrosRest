package br.com.bernardo.carrosrest.demo.api;

import java.util.List;

import br.com.bernardo.carrosrest.demo.dto.AddressDTO;
import br.com.bernardo.carrosrest.demo.dto.CarroDTO;
import br.com.bernardo.carrosrest.demo.service.ExternalAddressService;
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

	@Autowired
	private ExternalAddressService externalAddressService;
	
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

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public CarroDTO postCarro(@RequestBody CarroDTO carroDTORequest) {
		CarroDTO carroDTOResponse = carroService.insert(carroDTORequest);
		return carroDTOResponse;
	}

	@GetMapping("/cep/sincrono/{cep}")
	@ResponseStatus(value = HttpStatus.OK)
	public AddressDTO postAdress(@PathVariable("cep") String cep){
		AddressDTO addressDTO = externalAddressService.getAdressFromAPISynchronously(cep);
		return addressDTO;
	}

	@PutMapping("/{id}")
	public CarroDTO put(@PathVariable("id") Long id, @RequestBody CarroDTO carroDTORequest) {
		CarroDTO foundCarroEntity = carroService.update(carroDTORequest, id);
		return foundCarroEntity;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		carroService.delete(id);
		return ResponseEntity.ok().build();
	}

}
