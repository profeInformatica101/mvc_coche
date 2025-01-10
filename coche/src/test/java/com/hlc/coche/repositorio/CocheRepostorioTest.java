package com.hlc.coche.repositorio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.hlc.coche.entidad.Coche;

@DataJpaTest
class CocheRepostorioTest {

	@Autowired
	private CocheRepostorio cocheRepostorio;
	
	@Test
	void testSaveAndFindAll() {
		// Crear y guardar coches
		Coche coche1 = new Coche("Toyota", "1234ABC", "Rojo");
		Coche coche2 = new Coche("Ford", "9876ZXC", "Verde");
		
		cocheRepostorio.save(coche1);
		cocheRepostorio.save(coche2);
		
		List<Coche> coches = cocheRepostorio.findAll();
		
		Integer resultadoEsperado = 2;
		
		assertEquals(resultadoEsperado, coches.size(), "Debería haber 2 coches en la BBDD");
		assertTrue(coches.stream().anyMatch(c -> c.getMarca().equals("Toyota")), "Debería contener un coche Toyota");
		assertTrue(coches.stream().anyMatch(coche -> coche.getMarca().equals("Ford")), "Debería contener un coche Ford");
	}
	


}
