package edu.co.poli.showtimes.service;

import edu.co.poli.showtimes.persitence.entity.Showtime;
import edu.co.poli.showtimes.persitence.repository.ShowtimeRepository;
import edu.co.poli.showtimes.service.dto.ShowtimeInDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShowtimeServiceImpl implements ShowtimeService{

    private final ShowtimeRepository showtimeRepository;


    @Override
    public Showtime save(ShowtimeInDTO showtime) {
        ModelMapper modelMapper = new ModelMapper();
        return showtimeRepository.save(modelMapper.map(showtime, Showtime.class));
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

    @Override
    public Showtime update(Long id, ShowtimeInDTO showtime) {
        Optional<Showtime> showtime1 = showtimeRepository.findById(id);
        if(showtime1.isEmpty()) return null;
        Showtime showtime2 = showtime1.get();
        if(showtime.getDate() != null) showtime2.setDate(showtime.getDate());
        if(showtime.getMovies() != null) showtime2.setMovies(showtime.getMovies());
        return showtimeRepository.save(showtime2);
    }
}
