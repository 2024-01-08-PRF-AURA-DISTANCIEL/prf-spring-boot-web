package fr.maboite.demo.spring.boot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.maboite.demo.spring.boot.model.Bateau;

@Repository
public interface BateauDao extends CrudRepository<Bateau, Integer>{

}
