package fr.maboite.demo.spring.boot.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.maboite.demo.spring.boot.model.Company;

@SpringBootTest
public class CompanyDaoTest {

	@Autowired
	private CompanyDao companyDao;

	@Test
	public void testSave() {
		//ARRANGE
		Company company = new  Company();
		company.setName("Ma société");
		//ACT
		Company savedCompany = companyDao.save(company);
		//ASSERT
		Assertions.assertNotNull(savedCompany);
		Assertions.assertNotNull(savedCompany.getId());
		Assertions.assertEquals("Ma société", savedCompany.getName());
	}
	
}