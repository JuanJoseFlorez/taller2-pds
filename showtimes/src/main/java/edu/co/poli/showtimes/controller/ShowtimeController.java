package edu.co.poli.showtimes.controller;

import edu.co.poli.showtimes.helper.Response;
import edu.co.poli.showtimes.helper.ResponseBuild;
import edu.co.poli.showtimes.persitence.entity.Showtime;
import edu.co.poli.showtimes.service.ShowtimeService;
import edu.co.poli.showtimes.service.dto.ShowtimeInDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/showtime")
@RequiredArgsConstructor
public class ShowtimeController {

    private final ShowtimeService showtimeService;
    private final ResponseBuild builder;

    @PostMapping
    public Response save(@Valid @RequestBody ShowtimeInDTO showtime, BindingResult result) {
        if(result.hasErrors()){
            return builder.failed(this.formatMessage(result));
        }
        return builder.success(showtimeService.save(showtime));
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
    public Response delete(@PathVariable("id") Long id) {
        Showtime showtime = showtimeService.findById(id);
        if(showtime==null){
            return builder.failed("Not found");
        }
        showtimeService.delete(showtime);
        return builder.success("Eliminado correctamente");
    }
    @PutMapping("/{id}")
    public Response update(@PathVariable("id") Long id, @Valid @RequestBody ShowtimeInDTO customer, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(this.formatMessage(result));
        }
        return builder.success(showtimeService.update(id, customer));
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
