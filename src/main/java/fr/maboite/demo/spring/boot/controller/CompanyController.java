package fr.maboite.demo.spring.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.maboite.demo.spring.boot.model.Company;
import fr.maboite.demo.spring.boot.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);

	@Autowired
	private CompanyService companyService;

	@PostMapping
	public Company save(@RequestBody Company company) {
		LOGGER.info("Sauvegarde de Company par le contrôleur");
		companyService.save(company);
		return company;
	}

	@GetMapping("/{id}")
	public Company get(@PathVariable("id") Integer id) {
		LOGGER.info("Récupération de Company avec l'id : " + id);
		return companyService.findById(id);
	}

}
