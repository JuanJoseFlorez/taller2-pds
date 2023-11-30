package edu.co.poli.bookings.controller;


import edu.co.poli.bookings.helper.Response;
import edu.co.poli.bookings.helper.ResponseBuild;
import edu.co.poli.bookings.persistence.entity.Booking;
import edu.co.poli.bookings.service.BookingService;
import edu.co.poli.bookings.service.dto.BookingInDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final ResponseBuild builder;


    @PostMapping
    public Response save(@Valid @RequestBody BookingInDTO booking, BindingResult result) {
        if(result.hasErrors()){
            return builder.failed(this.formatMessage(result));
        }
        bookingService.save(booking);
        return builder.success(booking);
    }

    @GetMapping
    public List<Booking> findAll() {
        return bookingService.findAll();
    }

    @GetMapping("/{id}")
    public Booking findById(@PathVariable("id") Long id) {
        return bookingService.findById(id);
    }

    @GetMapping("/user/{userid}")
    public List<Booking> findByUserId(@PathVariable("userid") Long id) {
        return bookingService.findByUserId(id);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {
        Booking booking = bookingService.findById(id);
        if(booking==null){
            return builder.failed("Not found");
        }
        bookingService.delete(booking);
        return builder.success("Eliminado correctamente");
    }

    private List<Map<String, String>> formatMessage(BindingResult result) {
        return result.getFieldErrors().stream()
                .map(error -> {
                    Map<String, String> err = new HashMap<>();
                    err.put(error.getField(), error.getDefaultMessage());
                    return err;
                }).collect(Collectors.toList());
    }
}
