package edu.co.poli.bookings.persistence.repository;

import edu.co.poli.bookings.persistence.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("SELECT b FROM Booking b WHERE b.userid = :userId")
    List<Booking> findByUserId(@Param("userId") Long userId);
}
