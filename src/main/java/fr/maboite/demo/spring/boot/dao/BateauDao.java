package fr.maboite.demo.spring.boot.dao;

import fr.maboite.demo.spring.boot.model.Bateau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BateauDao extends JpaRepository<Bateau, Long> {
}
