package br.com.bernardo.carrosrest.demo.api;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/carros")
public class CarroController {
	
	@Autowired
	private CarroService carroService;

	@Autowired
	private ExternalAddressService externalAddressService;
	
	@GetMapping()
	public ResponseEntity<List<CarroDTO>> get() {
		return ResponseEntity.accepted().body(carroService.getCarros());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CarroDTO> getCarrosById(@PathVariable("id") Long id) {
		CarroDTO carroDTO = carroService.getCarroById(id);
		return ResponseEntity.ok().body(carroDTO);
	}

	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<CarroDTO>> getCarrosByTipo(@PathVariable("tipo") String tipo) {
		List<CarroDTO> carros = carroService.getCarrosByTipo(tipo);
		return ResponseEntity.ok().body(carros);
	}

	@PostMapping
	public ResponseEntity<CarroDTO> postCarro(@RequestBody CarroDTO carroDTORequest) {
		CarroDTO carroDTOResponse = carroService.insert(carroDTORequest);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(carroDTOResponse.getId()).toUri();
		return ResponseEntity.created(uri).body(carroDTOResponse);
	}

	@GetMapping("/cep/sincrono/{cep}")
	public ResponseEntity<AddressDTO> postAdress(@PathVariable("cep") String cep){
		AddressDTO addressDTO = externalAddressService.getAdressFromAPISynchronously(cep);
		return ResponseEntity.ok().body(addressDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> put(@PathVariable("id") Long id, @RequestBody CarroDTO carroDTORequest) {
		CarroDTO foundCarroEntity = carroService.update(carroDTORequest, id);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		carroService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
