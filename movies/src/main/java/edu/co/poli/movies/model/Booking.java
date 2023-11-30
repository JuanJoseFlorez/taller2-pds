package edu.co.poli.movies.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class Booking {
    private Long id;
    private Long userid;
    private Long showtimeid;
    private List<Long> movies;
}
