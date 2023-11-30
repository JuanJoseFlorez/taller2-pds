package edu.co.poli.movies.model;

import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Showtime {
    private Long id;

    private LocalDate date;

    private List<Long> movies;
}
