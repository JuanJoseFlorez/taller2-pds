package edu.co.poli.showtimes.service;

import edu.co.poli.showtimes.persitence.entity.Showtime;
import edu.co.poli.showtimes.service.dto.ShowtimeInDTO;

import java.util.List;

public interface ShowtimeService {

    Showtime save(ShowtimeInDTO showtime);
    void delete(Showtime showtime);
    List<Showtime> findAll();
    Showtime findById(Long id);

    Showtime update(Long id, ShowtimeInDTO showtime);

}
