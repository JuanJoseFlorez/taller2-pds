package edu.co.poli.showtimes.persitence.repository;

import edu.co.poli.showtimes.persitence.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
}
