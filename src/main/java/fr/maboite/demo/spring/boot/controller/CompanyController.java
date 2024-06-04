package fr.maboite.demo.spring.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.maboite.demo.spring.boot.dao.CompanyDao;
import fr.maboite.demo.spring.boot.model.Company;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);
	
	@Autowired
	private CompanyDao companyDao;
	
	@PostMapping
	public Company save(@RequestBody Company company) {
		LOGGER.info("Sauvegarde de Company par le contrôleur");
		companyDao.save(company);
		return company;
	}
	
}
