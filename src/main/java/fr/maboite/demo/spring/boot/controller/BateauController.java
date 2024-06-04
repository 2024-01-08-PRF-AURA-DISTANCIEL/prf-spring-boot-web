package fr.maboite.demo.spring.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.maboite.demo.spring.boot.correction.tp.model.Bateau;
import fr.maboite.demo.spring.boot.service.BateauService;

/**
 * Contrôleur REST : gère 
 * des requêtes HTTP avec des méthodes Java.
 * Ici, on gère toutes les requêtes dont l'URL 
 * commence par /bateaux
 */
@RestController
@RequestMapping("/bateaux")
public class BateauController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BateauController.class);
	
	/**
	 * Un contrôleur est un bean Spring : il est
	 * dans le contexte, on peut donc lui injecter
	 * d'autres beans Spring
	 */
	@Autowired
	private BateauService bateauService;
	
	/**
	 * GetMapping indique que les requêtes de type GET 
	 * vont être traitées par cette méthode. Ici, on 
	 * indique le suffixe de l'URL : /{id} . les guillemets
	 * servent à extraire de l'URL des variables : ce sont des
	 * PathVariables pour Spring Web.
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Bateau getById(@PathVariable("id") Integer id) {
		LOGGER.info("Récupération du bateau par le contrôleur, avec l'id : " + id);
		return bateauService.get(id);
	}
	
	/**
	 * PostMapping indique que les requêtes de type POST 
	 * vont être traitées par cette méthode. L'annotation
	 * @RequestBody demande à Spring de transformer le corps
	 * de la requête HTTP en argument de la méthode (attention,
	 * il faut que Spring puisse transformer correctement
	 * le corps en objet Java).
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping
	public Bateau save(@RequestBody Bateau bateau) {
		LOGGER.info("Sauvegarde du bateau par le contrôleur");
		bateauService.save(bateau);
		return bateau;
	}
	
	/**
	 * DeleteMapping indique que les requêtes de type DELETE 
	 * vont être traitées par cette méthode. Ici, on 
	 * utilise la même syntaxe que pour GetMapping
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Integer id) {
		LOGGER.info("Suppression du bateau par le contrôleur, avec l'id : " + id);
		bateauService.delete(id);
	}
	
	/**
	 * PostMapping avec RequestEntity et ResponseEntity
	 * sert à pouvoir récupérer des informations de la requête HTTP
	 * et manipuler des informations dans la réponse HTTP.
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping(path = "/custom", consumes = "application/json")
	public ResponseEntity<Bateau> saveCustom(RequestEntity<Bateau> requestBateau) {
		LOGGER.info("Sauvegarde du bateau par le contrôleur");
		Bateau bateau = requestBateau.getBody();
		
		
		LOGGER.info("Le content type demandé est : " + requestBateau.getHeaders().getContentType());
		
		ResponseEntity<Bateau> responseEntity = ResponseEntity
			.ok()
			.header("toto", "truc")
			.header("titi", "autre truc")
			.body(bateau);
		bateauService.save(bateau);
		return responseEntity;
	}
	
	
	
}
