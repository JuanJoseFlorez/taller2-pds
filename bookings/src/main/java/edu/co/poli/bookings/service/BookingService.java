package edu.co.poli.bookings.service;

import edu.co.poli.bookings.persistence.entity.Booking;

import java.util.List;

public interface BookingService {
    Booking save(Booking booking);
    void delete(Booking booking);
    List<Booking> findAll();
    Booking findById(Long id);
}
