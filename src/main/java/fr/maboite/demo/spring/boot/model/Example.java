package fr.maboite.demo.spring.boot.model;

import java.time.LocalDateTime;

public class Example {

	private Integer id;
	private String typeExample;
	private String nom;
	private LocalDateTime dateCreation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getTypeExample() {
		return typeExample;
	}

	public void setTypeExample(String typeExample) {
		this.typeExample = typeExample;
	}
	
}
