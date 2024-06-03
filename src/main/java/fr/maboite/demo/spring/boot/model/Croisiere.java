package fr.maboite.demo.spring.boot.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Croisiere {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	LocalDateTime dateDepart;
	LocalDateTime dateArrivee;
	String portDepart;
	String portArrive;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getPortArrive() {
		return portArrive;
	}
	public void setPortArrive(String portArrive) {
		this.portArrive = portArrive;
	}
}
