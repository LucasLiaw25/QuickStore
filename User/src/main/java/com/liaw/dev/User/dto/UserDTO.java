package com.liaw.dev.User.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    @NotBlank(message = "Nome obrigatório")
    private String name;
    @NotBlank(message = "Email obrigatório")
    private String email;
}
