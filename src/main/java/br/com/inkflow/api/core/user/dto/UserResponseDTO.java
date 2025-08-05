package br.com.inkflow.api.core.user.dto;

import br.com.inkflow.api.core.user.domain.UserRole;

public record UserResponseDTO(
        Long id,
        String name,
        String email,
        UserRole role
) {
}
