package br.com.barberflow.api.core.user.dto;

import br.com.barberflow.api.core.user.domain.UserRole;

public record UserResponseDTO(
        Long id,
        String name,
        String email,
        UserRole role
) {
}
