package edu.co.poli.showtimes.service;

import edu.co.poli.showtimes.persitence.entity.Showtime;
import edu.co.poli.showtimes.persitence.repository.ShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowtimeServiceImpl implements ShowtimeService{

    private final ShowtimeRepository showtimeRepository;


    @Override
    public Showtime save(Showtime showtime) {
        showtimeRepository.save(showtime);
        return showtime;
    }

    @Override
    public void delete(Showtime showtime) {
        showtimeRepository.delete(showtime);

    }

    @Override
    public List<Showtime> findAll() {
        return showtimeRepository.findAll();
    }

    @Override
    public Showtime findById(Long id) {
        return showtimeRepository.findById(id).orElse(null);
    }
}
