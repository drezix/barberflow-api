package br.com.barberflow.api.core.user.service;

import br.com.barberflow.api.core.user.domain.User;
import br.com.barberflow.api.core.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {
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
