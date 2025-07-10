package br.com.barberflow.api.core.user.mapper;

import br.com.barberflow.api.core.user.domain.User;
import br.com.barberflow.api.core.user.dto.UserRequestDTO;
import br.com.barberflow.api.core.user.dto.UserResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return new User(null, dto.name(), dto.email(), dto.password(), dto.role());
    }

    public UserResponseDTO toResponseDTO(User entity) {
        if (entity == null) {
            return null;
        }

        return new UserResponseDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getRole());
    }
}
