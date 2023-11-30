package edu.co.poli.users.model;

import lombok.Data;

import java.util.List;

@Data
public class Booking {
    private Long id;
    private Long userid;
    private Long showtimeid;
    private List<Long> movies;
}
