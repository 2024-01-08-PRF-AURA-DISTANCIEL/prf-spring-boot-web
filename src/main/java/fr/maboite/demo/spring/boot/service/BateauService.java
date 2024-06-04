package fr.maboite.demo.spring.boot.service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import fr.maboite.demo.spring.boot.model.Bateau;

@Component
public class BateauService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BateauService.class);
	
	private Long nextId = 1L;
	
	/**
	 * Sauvegarde un bateau.
	 * @param bateau : non null
	 */
	public void save(Bateau bateau) {
		if(bateau == null) {
			throw new IllegalArgumentException("Bateau ne peut être null");
		}
		
		LOGGER.info("Sauvegarde du bateau, avec le nom : " + bateau.getNom());
		
		if(bateau.getId() == null) {
			bateau.setId(nextId++);
		}
		if(bateau.getDateCreation() == null) {
			bateau.setDateCreation(LocalDateTime.now());
		}
	}
	
	/**
	 * Supprime un bateau à partir de  son identifiant
	 * @param id
	 */
	public void delete(Integer id ) {
		LOGGER.info("Suppression du bateau avec l'id : " + id);
	}
	
	/**
	 * Récupère un bateau à partir de son identifiant
	 * @param id
	 * @return
	 */
	public Bateau get(Integer id) {
		LOGGER.info("Récupération du bateau avec l'id : " + id);
		
		Bateau bateau = new Bateau();
		bateau.setId(Long.valueOf(id));
		bateau.setNom("Nouveau bateau");
		return bateau;
	}
	
	
}
