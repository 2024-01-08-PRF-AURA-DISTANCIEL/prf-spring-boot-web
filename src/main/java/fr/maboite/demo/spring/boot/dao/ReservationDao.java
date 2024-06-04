package fr.maboite.demo.spring.boot.dao;

import fr.maboite.demo.spring.boot.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationDao extends JpaRepository<Reservation, Long> {
}
