package tes.project.auth.domain.user.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthDTO(
        @NotBlank(message = "Login cannot be empty.")
        String login,

        @NotBlank(message = "Password cannot be empty.")
        String password
) {
}
