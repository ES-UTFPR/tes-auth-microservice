package tes.project.auth.domain.user.dto;

import tes.project.auth.domain.user.UserRole;

public record RegisterDTO(
    String login,
    String password,
    UserRole role
) {
}
