package edu.co.poli.bookings.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Movies {
    private Long id;

    private String title;

    private String director;

    private int rating;
}
