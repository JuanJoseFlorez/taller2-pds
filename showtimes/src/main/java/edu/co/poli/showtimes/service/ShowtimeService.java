package edu.co.poli.showtimes.service;

import edu.co.poli.showtimes.persitence.entity.Showtime;

import java.util.List;

public interface ShowtimeService {

    Showtime save(Showtime showtime);
    void delete(Showtime showtime);
    List<Showtime> findAll();
    Showtime findById(Long id);
}
