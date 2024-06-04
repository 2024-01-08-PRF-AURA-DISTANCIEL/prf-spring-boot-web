package fr.maboite.demo.spring.boot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Croisiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateDepart;
    private LocalDateTime dateArrivee;
    private String portDepart;
    private String portArrivee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPortArrivee() {
        return portArrivee;
    }

    public void setPortArrivee(String portArrivee) {
        this.portArrivee = portArrivee;
    }
}
