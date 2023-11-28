package edu.co.poli.showtimes.controller;

import edu.co.poli.showtimes.persitence.entity.Showtime;
import edu.co.poli.showtimes.service.ShowtimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/showtime")
@RequiredArgsConstructor
public class ShowtimeController {

    private final ShowtimeService showtimeService;

    @PostMapping
    public Showtime save(@RequestBody Showtime showtime) {
        return showtimeService.save(showtime);
    }

    @GetMapping
    public List<Showtime> findAll() {
        return showtimeService.findAll();
    }

    @GetMapping("/{id}")
    public Showtime findById(@PathVariable("id") Long id) {
        return showtimeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        Showtime customer = showtimeService.findById(id);
        showtimeService.delete(customer);


    }
}
