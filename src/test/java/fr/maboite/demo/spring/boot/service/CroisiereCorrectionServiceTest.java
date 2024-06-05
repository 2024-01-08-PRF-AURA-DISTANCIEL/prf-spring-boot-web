package fr.maboite.demo.spring.boot.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.maboite.demo.spring.boot.correction.tp.controller.CroisiereCorrectionDto;
import fr.maboite.demo.spring.boot.correction.tp.dao.BateauCorrectionDao;
import fr.maboite.demo.spring.boot.correction.tp.model.BateauCorrection;
import fr.maboite.demo.spring.boot.correction.tp.service.CroisiereCorrectionService;

@SpringBootTest
public class CroisiereCorrectionServiceTest {

	@Autowired
	private CroisiereCorrectionService croisiereCorrectionService;

	@Autowired
	private BateauCorrectionDao bateauCorrectionDao;

	@Test
	public void testFindById() {

		CroisiereCorrectionDto dto = new CroisiereCorrectionDto();
		dto.setNom("Croisière test par id");
		CroisiereCorrectionDto savedDto = this.croisiereCorrectionService.save(dto);

		CroisiereCorrectionDto loadedDto = this.croisiereCorrectionService.findById(savedDto.getId());

		Assertions.assertNotNull(loadedDto);

	}

	@Test
	public void testFindByPortDepart() {

		CroisiereCorrectionDto dto = new CroisiereCorrectionDto();
		dto.setNom("Croisière test");
		dto.setPortDepart("Capri");
		this.croisiereCorrectionService.save(dto);

		List<CroisiereCorrectionDto> croisieres = this.croisiereCorrectionService.findByPortDepart("Capri");

		Assertions.assertEquals(1, croisieres.size());
		Assertions.assertEquals("Capri", croisieres.get(0).getPortDepart());

	}

	@Test
	public void testSave() {
		BateauCorrection bateau = new BateauCorrection();
		BateauCorrection savedBateau = bateauCorrectionDao.save(bateau);

		CroisiereCorrectionDto dto = new CroisiereCorrectionDto();
		dto.setNom("Croisière test");
		dto.setBateauId(savedBateau.getId());

		CroisiereCorrectionDto savedDto = this.croisiereCorrectionService.save(dto);

		Assertions.assertNotNull(savedDto.getId());
		Assertions.assertNotNull(savedDto.getNom());
		Assertions.assertNotNull(savedDto.getBateauId());
	}

}
