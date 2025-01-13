package tes.project.auth.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterDTO(
    @NotBlank(message = "Login cannot be empty.")
    @Size(min = 3, max = 50, message = "Login must be between 3 and 50 characters.")
    String login,

    @NotBlank(message = "Email cannot be empty.")
    String email,

    @NotBlank(message = "Password cannot be empty.")
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    String password
) {
}
