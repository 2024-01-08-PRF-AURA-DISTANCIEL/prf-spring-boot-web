package fr.maboite.demo.spring.boot.correction.tp.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CroisiereCorrection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private LocalDateTime dateDepart;
	private LocalDateTime dateArrivee;
	private String portDepart;
	private String portArrivee;

	/**
	 * ManyToOne et JoinColumn indiquent que l'entité reservation liée doit être
	 * persistée dans la colonne RESERVATION_ID , en prenant en compte l'identifiant
	 * de l'entité reservation. JoinColumn n'est pas obligatoire. ATtention, par
	 * défaut le fetchType est EAGER
	 */
	@ManyToOne
	@JoinColumn(name = "RESERVATION_ID")
	private ReservationCorrection reservation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDateTime getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDateTime dateDepart) {
		this.dateDepart = dateDepart;
	}

	public LocalDateTime getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(LocalDateTime dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public String getPortDepart() {
		return portDepart;
	}

	public void setPortDepart(String portDepart) {
		this.portDepart = portDepart;
	}

	public String getPortArrivee() {
		return portArrivee;
	}

	public void setPortArrivee(String portArrivee) {
		this.portArrivee = portArrivee;
	}

	public ReservationCorrection getReservation() {
		return reservation;
	}

	public void setReservation(ReservationCorrection reservation) {
		this.reservation = reservation;
	}

}
