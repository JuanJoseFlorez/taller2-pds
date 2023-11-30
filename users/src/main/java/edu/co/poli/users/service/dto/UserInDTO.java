package edu.co.poli.users.service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserInDTO {
    @NotBlank(message = "Name no puede estar en blanco")
    private String name;

    @NotBlank(message = "lastname no puede estar en blanco")
    private String lastname;
}
