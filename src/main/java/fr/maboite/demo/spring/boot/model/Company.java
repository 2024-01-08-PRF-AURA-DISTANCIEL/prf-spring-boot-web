package fr.maboite.demo.spring.boot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entité : classe que JPA peut persister
 */
@Entity // Décrit une entité persistable
public class Company {

	@Id // Décrit l’attribut servant d'identifiant et la clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) // décrit la méthode de génération de l’identifiant
	private Integer id;

	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}