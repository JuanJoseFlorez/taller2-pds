package edu.co.poli.movies.service;

import edu.co.poli.movies.clientFeign.BookingsClient;
import edu.co.poli.movies.clientFeign.ShowtimesClient;
import edu.co.poli.movies.helper.Response;
import edu.co.poli.movies.model.Booking;
import edu.co.poli.movies.model.Showtime;
import edu.co.poli.movies.persistence.entity.Movie;
import edu.co.poli.movies.persistence.repository.MovieRepository;
import edu.co.poli.movies.service.dto.MovieInDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;
    private final BookingsClient bookingsClient;
    private final ShowtimesClient showtimesClient;
    private final CircuitBreakerFactory cbFactory;

    @Override
    public Movie save(MovieInDTO movie) {
        ModelMapper modelMapper = new ModelMapper();
        return movieRepository.save(modelMapper.map(movie, Movie.class));
    }

    @Override
    public String delete(Movie movie) {
        List<Booking> booking= findAllBooking();
        boolean existBooking = booking.stream()
                .anyMatch(bookingItem -> bookingItem.getMovies().contains(movie.getId()));
        List<Showtime> showtime = findAllShowtimes();
        boolean existShowtime = showtime.stream()
                .anyMatch(showtimeItem -> showtimeItem.getMovies().contains(movie.getId()));
        if(!existBooking && !existShowtime){
            movieRepository.delete(movie);
            return "Eliminado correctamente";
        }
        return "Existe una programacion o reserva con esta pelicula";
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public List<Booking> findAllBooking(){
        return cbFactory.create("findAllBooking")
                .run(()->bookingsClient.findAll(),
                        e-> Collections.emptyList()  );
    }
    public List<Showtime> findAllShowtimes(){
        return cbFactory.create("findAllShowtimes")
                .run(()->showtimesClient.findAll(),
                        e-> Collections.emptyList()  );
    }
}


