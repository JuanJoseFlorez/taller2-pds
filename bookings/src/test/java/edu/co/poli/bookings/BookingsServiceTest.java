package edu.co.poli.bookings;

import edu.co.poli.bookings.persistence.entity.Booking;
import edu.co.poli.bookings.persistence.repository.BookingRepository;
import edu.co.poli.bookings.service.BookingService;
import edu.co.poli.bookings.service.BookingServiceImpl;
import edu.co.poli.bookings.service.dto.BookingInDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


public class BookingsServiceTest {
    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    private Booking booking;

    @Test
    void findByUserId(){
        MockitoAnnotations.initMocks(this);
        booking = new Booking();
        booking.setUserid(5L);
        booking.setShowtimeid(5L);
        booking.setId(1L);
        List<Booking> expectedBookings = Arrays.asList(booking);
        when(bookingRepository.findByUserId(booking.getId())).thenReturn(expectedBookings);
        assertNotNull(bookingService.findByUserId(5L));
    }
}
