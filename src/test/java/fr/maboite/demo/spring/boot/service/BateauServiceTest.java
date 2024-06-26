package fr.maboite.demo.spring.boot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.maboite.demo.spring.boot.correction.tp.model.BateauCorrection;

@SpringBootTest
class BateauServiceTest {

	@Autowired
	BateauService bateauService;

	@Test
	public void testSaveNewBateau() {
		BateauCorrection bateau = new BateauCorrection();
		String nomBateau = "Mon beau bateau";
		bateau.setNom(nomBateau);
		this.bateauService.save(bateau);
		Assertions.assertNotNull(bateau.getId());
		Assertions.assertNotNull(bateau.getDateCreation());
		Assertions.assertEquals(nomBateau, bateau.getNom());
	}
	
	@Test
	public void testSaveNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> this.bateauService.save(null));
	}

	@Test
	public void testDelete() {
		this.bateauService.delete(4);
	}

	@Test
	public void testGet() {
		int id = 5;
		BateauCorrection bateau = this.bateauService.get(id);
		Assertions.assertNotNull(bateau);
		Assertions.assertEquals(id, bateau.getId());

	}

}
