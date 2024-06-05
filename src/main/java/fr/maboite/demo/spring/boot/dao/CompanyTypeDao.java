package fr.maboite.demo.spring.boot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.maboite.demo.spring.boot.model.CompanyType;

@Repository
public interface CompanyTypeDao extends CrudRepository<CompanyType, Integer> {

}