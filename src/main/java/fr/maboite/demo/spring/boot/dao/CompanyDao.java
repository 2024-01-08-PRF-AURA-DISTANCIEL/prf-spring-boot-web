package fr.maboite.demo.spring.boot.dao;

import org.springframework.data.repository.CrudRepository;

import fr.maboite.demo.spring.boot.model.Company;

public interface CompanyDao extends CrudRepository<Company, Integer> {

}
