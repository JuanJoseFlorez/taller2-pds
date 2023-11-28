package edu.co.poli.bookings.service;

import edu.co.poli.bookings.persistence.entity.Booking;
import edu.co.poli.bookings.persistence.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService{

    private final BookingRepository bookingRepository;


    @Override
    public Booking save(Booking booking) {
        bookingRepository.save(booking);

        return booking;
    }

    @Override
    public void delete(Booking booking) {
        bookingRepository.delete(booking);

    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();

    }

    @Override
    public Booking findById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }
}
