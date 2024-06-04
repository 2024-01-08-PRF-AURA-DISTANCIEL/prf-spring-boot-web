package fr.maboite.demo.spring.boot.correction.tp.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.maboite.demo.spring.boot.controller.BateauController;
import fr.maboite.demo.spring.boot.correction.tp.dao.BateauCorrectionDao;
import fr.maboite.demo.spring.boot.correction.tp.model.BateauCorrection;

@RestController
@RequestMapping("/correction/bateaux")
public class BateauCorrectionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BateauController.class);

	@Autowired
	private BateauCorrectionDao bateauCorrectionDao;

	@PostMapping
	public BateauCorrection save(@RequestBody BateauCorrection bateau) {
		LOGGER.info("Sauvegarde de Bateau par le contrôleur");
		bateauCorrectionDao.save(bateau);
		return bateau;
	}

	@GetMapping("/{id}")
	public BateauCorrection get(@PathVariable("id") Integer id) {
		LOGGER.info("Récupération de Bateau avec l'id : " + id);
		Optional<BateauCorrection> bateauOptional = bateauCorrectionDao.findById(id);
		if (bateauOptional.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No bateau found");
		} else {
			BateauCorrection bateau = bateauOptional.get();
			return bateau;
		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		LOGGER.info("Suppression de Bateau avec l'id : " + id);
		bateauCorrectionDao.deleteById(id);
	}

}
