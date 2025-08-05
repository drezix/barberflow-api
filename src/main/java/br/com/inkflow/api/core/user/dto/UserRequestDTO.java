package br.com.inkflow.api.core.user.dto;

import br.com.inkflow.api.core.user.domain.UserRole;

public record UserRequestDTO(
        String name,
        String email,
        String password,
        UserRole role
) {
}
