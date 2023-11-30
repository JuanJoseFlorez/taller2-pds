package edu.co.poli.movies.service.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MovieInDTO {
    @NotBlank(message = "Title no puede estar en blanco")
    private String title;

    @NotBlank(message = "Director no puede estar en blanco")
    private String director;

    @Min(value = 1, message = "Rating debe ser un valor entre 1 y 5")
    @Max(value = 5, message = "Rating debe ser un valor entre 1 y 5")
    private int rating;
}
