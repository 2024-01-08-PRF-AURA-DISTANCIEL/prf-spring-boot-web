package fr.maboite.demo.spring.boot.correction.tp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ReservationCorrection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;

	/**
	 * ManyToOne et JoinColumn indiquent que l'entité reservation liée doit être
	 * persistée dans la colonne BATEAU_ID , en prenant en compte l'identifiant de
	 * l'entité reservation. JoinColumn n'est pas obligatoire. ATtention, par défaut
	 * le fetchType est EAGER
	 */
	@ManyToOne
	@JoinColumn(name = "BATEAU_ID")
	private BateauCorrection bateau;

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public BateauCorrection getBateau() {
		return bateau;
	}

	public void setBateau(BateauCorrection bateau) {
		this.bateau = bateau;
	}
	
	

}
