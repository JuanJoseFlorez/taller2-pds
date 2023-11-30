package edu.co.poli.movies.persistence.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @NotBlank(message = "Title no puede estar en blanco")
    private String title;

    @NotBlank(message = "Director no puede estar en blanco")
    private String director;

    @Min(value = 1, message = "Rating debe ser un valor entre 1 y 5")
    @Max(value = 5, message = "Rating debe ser un valor entre 1 y 5")
    private int rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
