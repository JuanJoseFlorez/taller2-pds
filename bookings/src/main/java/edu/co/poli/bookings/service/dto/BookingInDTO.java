package edu.co.poli.bookings.service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class BookingInDTO {
    @NotNull(message = "UserId no puede ser nulo")
    private Long userid;

    @NotNull(message = "ShowtimeId no puede ser nulo")
    private Long showtimeid;
    private List<Long> movies;
}
