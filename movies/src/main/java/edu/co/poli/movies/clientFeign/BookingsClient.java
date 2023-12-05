package edu.co.poli.movies.clientFeign;

import edu.co.poli.movies.model.Booking;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "bookings")
public interface BookingsClient {
    @GetMapping("/api/v2/poli/booking")
    List<Booking> findAll();
}
