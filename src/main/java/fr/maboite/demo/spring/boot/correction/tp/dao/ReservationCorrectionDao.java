package fr.maboite.demo.spring.boot.correction.tp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.maboite.demo.spring.boot.correction.tp.model.ReservationCorrection;

@Repository
public interface ReservationCorrectionDao extends CrudRepository<ReservationCorrection, Long> {

	//Récupérer les réservations par nom.
	List<ReservationCorrection> getByNom(String nom);
	
	//Récupérer les réservations par nom et prenom
	List<ReservationCorrection> getByNomAndPrenom(String nom, String prenom);

	//Récupérer les réservations par  nom et prenom sans tenir compte de la casse
	List<ReservationCorrection> getByNomAndPrenomAllIgnoreCase(String nom, String prenom);

	//Récupérer les réservations par  le port de départ de la croisière
	List<ReservationCorrection> getByCroisierePortDepart(String portDepart);
//	@Query("select r from ReservationCorrection r "
//			+ " inner join r.croisiere c "
//			+ " where c.portDepart = :portDepart")
//	List<ReservationCorrection> getByCroisierePortDepart(@Param("portDepart") String portDepart);
	
	//Récupérer les réservations liées à un nom de bateau.
	@Query("select r from ReservationCorrection r "
			+ " left outer join r.croisiere c "
			+ " left outer join c.bateau b "
			+ " where b.nom = : nomBateau ")
	List<ReservationCorrection> findByNomBateau(@Param("nomBateau") String nomBateau);
	
}