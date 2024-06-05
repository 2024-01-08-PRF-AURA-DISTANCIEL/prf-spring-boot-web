package fr.maboite.demo.spring.boot.correction.tp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.maboite.demo.spring.boot.correction.tp.model.BateauCorrection;

@Repository
public interface BateauCorrectionDao extends CrudRepository<BateauCorrection, Integer> {

	//Récupérer un bateau lié à une certaine croisière.
	@Query("select b from BateauCorrection b "
			+ " left outer join b.croisieres c "
			+ " where c.id = :idCroisiere ")
	List<BateauCorrection> findByIdCroisiere(@Param("idCroisiere") Long idCroisiere);
}