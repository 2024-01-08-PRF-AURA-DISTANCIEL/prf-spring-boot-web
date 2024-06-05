package fr.maboite.demo.spring.boot.correction.tp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.maboite.demo.spring.boot.controller.BateauController;
import fr.maboite.demo.spring.boot.correction.tp.service.CroisiereCorrectionService;

/**
 * Un RestController qui utilise un DTO à la place 
 * de l'entité.
 */
@RestController
@RequestMapping("/correction/croisieres")
public class CroisiereCorrectionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BateauController.class);

	@Autowired
	private CroisiereCorrectionService croisiereService;

	@PostMapping
	public CroisiereCorrectionDto save(@RequestBody CroisiereCorrectionDto croisiereCorrectionDto) {
		LOGGER.info("Sauvegarde de Croisiere par le contrôleur");
		return croisiereService.save(croisiereCorrectionDto);
	}
	
	@GetMapping("/{id}")
	public CroisiereCorrectionDto get(@PathVariable("id") Long id ) {
		LOGGER.info("Récupération de Croisiere par le contrôleur");
		return croisiereService.findById(id);
	}
	

	/**
	 * Répont à une requête : de type : 
	 * localhost:8080/correction/croisieres?portDepart=Bari
	 * @param portDepart
	 * @return
	 */
	@GetMapping()
	public List<CroisiereCorrectionDto> getByPortDepart(@RequestParam("portDepart") String portDepart) {
		LOGGER.info("Récupération de Croisiere par le contrôleur, via le port de départ");
		return croisiereService.findByPortDepart(portDepart);
	}

}
