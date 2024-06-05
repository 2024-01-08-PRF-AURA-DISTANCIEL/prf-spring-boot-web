package fr.maboite.demo.spring.boot.correction.tp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.maboite.demo.spring.boot.correction.tp.model.CroisiereCorrection;

@Repository
public interface CroisiereCorrectionDao extends CrudRepository<CroisiereCorrection, Long> {

	//Récupérer les croisieres par port de départ.
	List<CroisiereCorrection> findByPortDepart(String portDepart);
	
	//Récupérer les croisières liées à un nom de bateau.
	@Query("select c from CroisiereCorrection c "
			+ " left outer join c.bateau b "
			+ " where b.nom = : nomBateau ")
	List<CroisiereCorrection> findByNomBateau(@Param("nomBateau") String nomBateau);
	
}