package fr.maboite.demo.spring.boot.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.maboite.demo.spring.boot.correction.tp.dao.CroisiereCorrectionDao;
import fr.maboite.demo.spring.boot.correction.tp.dao.ReservationCorrectionDao;
import fr.maboite.demo.spring.boot.correction.tp.model.CroisiereCorrection;
import fr.maboite.demo.spring.boot.correction.tp.model.ReservationCorrection;

@SpringBootTest
public class ReservationCorrectionDaoTest {

	@Autowired
	private ReservationCorrectionDao reservationDao;

	@Autowired
	private CroisiereCorrectionDao croisiereDao;

	@Test
	public void testSave() {
		// ARRANGE
		ReservationCorrection reservationCorrection = new ReservationCorrection();
		reservationCorrection.setNom("Ma réservation");
		// ACT
		ReservationCorrection savedReservationCorrection = reservationDao.save(reservationCorrection);
		// ASSERT
		Assertions.assertNotNull(savedReservationCorrection);
		Assertions.assertNotNull(savedReservationCorrection.getId());
		Assertions.assertEquals("Ma réservation", savedReservationCorrection.getNom());
	}

	@Test
	public void testSaveWithReservationCorrectionType() {
		// ARRANGE
		// Création de reservationCorrection
		ReservationCorrection reservationCorrection = new ReservationCorrection();
		reservationCorrection.setNom("Ma réservation");

		// Création de Croisiere
		CroisiereCorrection monCroisiere = new CroisiereCorrection();
		monCroisiere.setNom("Mon beau croisiere");
		CroisiereCorrection savedCroisiere = croisiereDao.save(monCroisiere);

		// Rattachement des deux objets
		reservationCorrection.setCroisiere(savedCroisiere);

		// ACT
		// Sauvegarde de reservationCorrection
		ReservationCorrection savedReservationCorrection = reservationDao.save(reservationCorrection);

		// ASSERT
		Assertions.assertNotNull(savedReservationCorrection.getCroisiere());

	}

	@Test
	public void testGetByNom() {
		ReservationCorrection reservationCorrection = new ReservationCorrection();
		String nom = "Dupont";
		reservationCorrection.setNom(nom);
		ReservationCorrection savedReservationCorrection = reservationDao.save(reservationCorrection);

		List<ReservationCorrection> reservations = reservationDao.getByNom(nom);
		Assertions.assertEquals(1, reservations.size());
		Assertions.assertEquals(nom, reservations.get(0).getNom());
	}

	@Test
	public void testGetByNomAndPrenom() {
		ReservationCorrection reservationCorrection = new ReservationCorrection();
		String nom = "Durand";
		String prenom = "Jean";
		reservationCorrection.setNom(nom);
		reservationCorrection.setPrenom(prenom);
		ReservationCorrection savedReservationCorrection = reservationDao.save(reservationCorrection);

		List<ReservationCorrection> reservations = reservationDao.getByNomAndPrenom(nom, prenom);
		Assertions.assertEquals(1, reservations.size());
		Assertions.assertEquals(nom, reservations.get(0).getNom());
		Assertions.assertEquals(prenom, reservations.get(0).getPrenom());
	}

	@Test
	public void testGetByNomAndPrenomAllIgnoreCase() {
		ReservationCorrection reservationCorrection = new ReservationCorrection();
		String nom = "Dupond";
		String prenom = "Jean";
		reservationCorrection.setNom(nom);
		reservationCorrection.setPrenom(prenom);
		ReservationCorrection savedReservationCorrection = reservationDao.save(reservationCorrection);

		List<ReservationCorrection> reservations = reservationDao.getByNomAndPrenomAllIgnoreCase("dupond", "JEAN");
		Assertions.assertEquals(1, reservations.size());
		Assertions.assertEquals(nom, reservations.get(0).getNom());
		Assertions.assertEquals(prenom, reservations.get(0).getPrenom());
	}

	@Test
	public void testGetByCroisierePortDepart() {
		ReservationCorrection reservationCorrection = new ReservationCorrection();
		reservationCorrection.setNom("Ma réservation liée à une croisiere");

		CroisiereCorrection maCroisiere = new CroisiereCorrection();
		maCroisiere.setNom("Super croisière");
		maCroisiere.setPortDepart("Marseille");
		CroisiereCorrection savedCroisiere = croisiereDao.save(maCroisiere);

		reservationCorrection.setCroisiere(savedCroisiere);
		reservationDao.save(reservationCorrection);
		
		List<ReservationCorrection> reservations = reservationDao.getByCroisierePortDepart("Marseille");
		Assertions.assertEquals(1, reservations.size());
	}

}