package fr.maboite.demo.spring.boot.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import fr.maboite.demo.spring.boot.dao.BateauDao;
import fr.maboite.demo.spring.boot.model.Bateau;

@Component
public class BateauService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BateauService.class);
	
	private Integer nextId = 1;
	@Autowired
	private BateauDao bateauDao;
	
	/**
	 * Sauvegarde un bateau.
	 * @param bateau : non null
	 */
	public Bateau save(Bateau bateau) {
		if(bateau == null) {
			throw new IllegalArgumentException("Bateau ne peut être null");
		}
		
		LOGGER.info("Sauvegarde du bateau, avec le nom : " + bateau.getNom());
		if(bateau.getNom() == null) {
			throw new IllegalArgumentException("Le nom du bateau ne peut être null");
		}
		return bateauDao.save(bateau);
//		if(bateau.getId() == null) {
//			bateau.setId(nextId++);
//		}
//		if(bateau.getDateCreation() == null) {
//			bateau.setDateCreation(LocalDateTime.now());
//		}
	}
	
	/**
	 * Supprime un bateau à partir de  son identifiant
	 * @param id
	 */
	public void delete(Integer id ) {
		LOGGER.info("Suppression du bateau avec l'id : " + id);
		bateauDao.deleteById(id);
	}
	
	/**
	 * Récupère un bateau à partir de son identifiant
	 * @param id
	 * @return
	 */
	public Bateau get(Integer id) {
		LOGGER.info("Récupération du bateau avec l'id : " + id);
		Optional<Bateau> bateauOptional = bateauDao.findById(id);
		if(bateauOptional.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No company found");
		} else {
			return bateauOptional.get();
		}
	}
	
	
}
