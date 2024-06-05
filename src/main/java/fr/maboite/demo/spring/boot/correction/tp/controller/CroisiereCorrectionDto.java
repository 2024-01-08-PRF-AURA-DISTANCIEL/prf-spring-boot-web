package fr.maboite.demo.spring.boot.correction.tp.controller;

public class CroisiereCorrectionDto {

	private Long id;
	private String nom;
	private Integer bateauId;
	private String portDepart;
	private String portArrivee;

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

	public Integer getBateauId() {
		return bateauId;
	}

	public void setBateauId(Integer bateauId) {
		this.bateauId = bateauId;
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
	
	

}
