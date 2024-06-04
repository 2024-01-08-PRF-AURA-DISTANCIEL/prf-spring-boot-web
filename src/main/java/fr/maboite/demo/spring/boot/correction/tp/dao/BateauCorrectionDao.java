package fr.maboite.demo.spring.boot.correction.tp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.maboite.demo.spring.boot.model.Bateau;

@Repository
public interface BateauCorrectionDao extends CrudRepository<Bateau, Integer> {

}