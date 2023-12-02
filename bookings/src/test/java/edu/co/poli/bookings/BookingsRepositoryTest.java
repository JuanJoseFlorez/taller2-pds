package edu.co.poli.bookings;

import edu.co.poli.bookings.persistence.entity.Booking;
import edu.co.poli.bookings.persistence.repository.BookingRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookingsRepositoryTest {
    @Mock
    private BookingRepository bookingRepository;

    @Test
    void findAll(){
        MockitoAnnotations.initMocks(this);
        Booking booking = new Booking();
        booking.setUserid(5L);
        booking.setShowtimeid(5L);
        bookingRepository.save(booking);
        List<Booking> founds = bookingRepository.findAll();
        assertNotNull(founds);
    }
}
