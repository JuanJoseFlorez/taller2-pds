package edu.co.poli.bookings.service;

import edu.co.poli.bookings.persistence.entity.Booking;
import edu.co.poli.bookings.service.dto.BookingInDTO;

import java.util.List;

public interface BookingService {
    Booking save(BookingInDTO booking);
    void delete(Booking booking);
    List<Booking> findAll();
    Booking findById(Long id);

    List<Booking> findByUserId(Long id);

}
