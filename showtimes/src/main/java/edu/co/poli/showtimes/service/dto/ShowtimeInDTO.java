package edu.co.poli.showtimes.service.dto;

import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ShowtimeInDTO {
    @NotNull(message = "Date no puede ser nulo")
    //@FutureOrPresent(message = "Date debe ser una fecha actual o posterior")
    private LocalDate date;

    private List<Long> movies;
}
