package fr.maboite.demo.spring.boot.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.maboite.demo.spring.boot.correction.tp.dao.BateauCorrectionDao;
import fr.maboite.demo.spring.boot.correction.tp.dao.ReservationCorrectionDao;
import fr.maboite.demo.spring.boot.correction.tp.model.BateauCorrection;
import fr.maboite.demo.spring.boot.correction.tp.model.ReservationCorrection;

@SpringBootTest
public class ReservationCorrectionDaoTest {

	@Autowired
	private ReservationCorrectionDao reservationDao;

	@Autowired
	private BateauCorrectionDao bateauDao;

	@Test
	public void testSave() {
		//ARRANGE
		ReservationCorrection reservationCorrection = new  ReservationCorrection();
		reservationCorrection.setNom("Ma réservation");
		//ACT
		ReservationCorrection savedReservationCorrection = reservationDao.save(reservationCorrection);
		//ASSERT
		Assertions.assertNotNull(savedReservationCorrection);
		Assertions.assertNotNull(savedReservationCorrection.getId());
		Assertions.assertEquals("Ma réservation", savedReservationCorrection.getNom());
	}

	@Test
	public void testSaveWithReservationCorrectionType() {
		//ARRANGE
		//Création de reservationCorrection
		ReservationCorrection reservationCorrection = new  ReservationCorrection();
		reservationCorrection.setNom("Ma réservation");
		
		//Création de Bateau
		BateauCorrection monBateau = new BateauCorrection();
		monBateau.setNom("Mon beau bateau");
		BateauCorrection savedBateau = bateauDao.save(monBateau);
		
		//Rattachement des deux objets
		reservationCorrection.setBateau(savedBateau);
		
		//ACT
		//Sauvegarde de reservationCorrection
		ReservationCorrection savedReservationCorrection = reservationDao.save(reservationCorrection);
		
		//ASSERT
		Assertions.assertNotNull(savedReservationCorrection.getBateau());
		
	}
	
	
}