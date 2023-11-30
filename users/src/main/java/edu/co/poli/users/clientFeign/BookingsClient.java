package edu.co.poli.users.clientFeign;

import edu.co.poli.users.model.Booking;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "bookings")
public interface BookingsClient {
    @GetMapping("/api/v2/poli/booking")
    List<Booking> findAll();

    @GetMapping("/api/v2/poli/booking/user/{userid}")
    List<Booking> findByUserId(@PathVariable("userid") Long id);
}
