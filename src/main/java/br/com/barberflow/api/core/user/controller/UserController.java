package br.com.barberflow.api.core.user.controller;

import br.com.barberflow.api.core.user.domain.User;
import br.com.barberflow.api.core.user.dto.UserRequestDTO;
import br.com.barberflow.api.core.user.dto.UserResponseDTO;
import br.com.barberflow.api.core.user.mapper.UserMapper;
import br.com.barberflow.api.core.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        User newUser = userService.createUser(userRequestDTO);
        UserResponseDTO responseDTO = userMapper.toResponseDTO(newUser);
        return ResponseEntity.status(201).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findUserById(@PathVariable Long id) {
        User user = userService.findUserById(id);
        UserResponseDTO responseDTO = userMapper.toResponseDTO(user);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAllUsers() {
        List<User> users = userService.findAllUsers();
        List<UserResponseDTO> responseDTOs = users.stream()
                .map(userMapper::toResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOs);
    }
}
