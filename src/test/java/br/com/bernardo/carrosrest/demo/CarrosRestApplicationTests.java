package br.com.bernardo.carrosrest.demo;

import br.com.bernardo.carrosrest.demo.api.exception.ObjectNotFoundException;
import br.com.bernardo.carrosrest.demo.domain.CarroEntity;
import br.com.bernardo.carrosrest.demo.dto.CarroDTO;
import br.com.bernardo.carrosrest.demo.service.CarroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static junit.framework.TestCase.*;

@SpringBootTest
class CarrosRestApplicationTests {

	@Autowired
	private CarroService carroService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testSave() {
		CarroEntity carro = new CarroEntity();
		carro.setNome("Ferrari");
		carro.setTipo("esportivos");

		CarroDTO carroDTO = carroService.insert(carro);
		assertNotNull(carroDTO);

		Long id = carroDTO.getId();
		assertNotNull(id);

		//Buscar o objeto
		carroDTO = carroService.getCarroById(id);
		assertNotNull(carroDTO);

		assertEquals("Ferrari", carro.getNome());
		assertEquals("esportivos", carro.getTipo());

		//Deletar o objeto
		carroService.delete(id);

		//Verificar se deletou
		try {
			assertNull(carroService.getCarroById(id));
		} catch (ObjectNotFoundException ex) {
			//OK
		}

	}
	@Test
	public void testListaPorTipo(){
		assertEquals(10, carroService.getCarrosByTipo("classicos").size());
		assertEquals(10,carroService.getCarrosByTipo("esportivos").size());
		assertEquals(10,carroService.getCarrosByTipo("luxo").size());
		assertEquals(0, carroService.getCarrosByTipo("x").size());
	}
	@Test
	public void testGet() {
		CarroDTO carroDTO = carroService.getCarroById(11L);
		assertNotNull(carroDTO);
		assertEquals("Ferrari FF", carroDTO.getNome());

	}

}
