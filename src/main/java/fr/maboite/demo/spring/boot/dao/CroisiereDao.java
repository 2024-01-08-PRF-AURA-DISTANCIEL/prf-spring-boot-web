package fr.maboite.demo.spring.boot.dao;

import fr.maboite.demo.spring.boot.model.Croisiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CroisiereDao extends JpaRepository<Croisiere, Long> {
}
