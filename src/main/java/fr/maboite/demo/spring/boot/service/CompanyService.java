package fr.maboite.demo.spring.boot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.maboite.demo.spring.boot.dao.CompanyDao;
import fr.maboite.demo.spring.boot.model.Company;

@Component
public class CompanyService {

	@Autowired
	private CompanyDao companyDao;

	public Company save(Company company) {
		return companyDao.save(company);
	}

	public Company findById(Integer id) {
		Optional<Company> companyFromDao = companyDao.findById(id);
		if (companyFromDao.isEmpty()) {
			return null;
		} else {
			return companyFromDao.get();
		}
		// La ligne ci-dessus est équivalente à l'algorithme ci-dessous :
		// Company company = companyDao.findById(id);
		// if(company == null) {
		// throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No company found");
		// }else {
		// return company;
		// }
	}

	/**
	 * Méthode transactionnelle pour gérer correctement les transferts
	 * de monnaie en base de données.
	 * @param company1
	 * @param company2
	 * @param montant
	 */
	@Transactional
	public void transfer(Company company1, Company company2, int montant) {
		int cashCompany1 = company1.getCash();
		int cashCompany2 = company2.getCash();

		company2.setCash(cashCompany2 + montant);
		// Si un code hyper compliqué qui peut échouer
		// Lance une exception, la transaction sera rollback :
		// Un ordre ROLLBACK sera envoyé par SQL.
		companyDao.save(company2);

		company1.setCash(cashCompany1 - montant);
		companyDao.save(company1);
		// Si on sort de la méthode, un ordre
		// COMMIT sera envoyé par SQL
	}

}
