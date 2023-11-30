package edu.co.poli.movies.clientFeign;

import edu.co.poli.movies.helper.Response;
import edu.co.poli.movies.model.Showtime;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "showtimes")
public interface ShowtimesClient {
    @GetMapping("/api/v2/poli/showtime")
    List<Showtime> findAll();
}
