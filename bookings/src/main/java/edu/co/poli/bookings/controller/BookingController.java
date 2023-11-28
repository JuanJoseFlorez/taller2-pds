package edu.co.poli.bookings.controller;


import edu.co.poli.bookings.persistence.entity.Booking;
import edu.co.poli.bookings.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;


    @PostMapping
    public Booking save(@RequestBody Booking booking) {
        return bookingService.save(booking);
    }

    @GetMapping
    public List<Booking> findAll() {
        return bookingService.findAll();
    }

    @GetMapping("/{id}")
    public Booking findById(@PathVariable("id") Long id) {
        return bookingService.findById(id);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        Booking booking = bookingService.findById(id);
        bookingService.delete(booking);
    }
}
