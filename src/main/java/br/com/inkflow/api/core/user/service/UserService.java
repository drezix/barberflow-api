package br.com.inkflow.api.core.user.service;

import br.com.inkflow.api.core.user.domain.User;
import br.com.inkflow.api.core.user.dto.UserRequestDTO;
import br.com.inkflow.api.core.user.mapper.UserMapper;
import br.com.inkflow.api.core.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User createUser(UserRequestDTO userRequestDTO) {
        User user = userMapper.toEntity(userRequestDTO);
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
