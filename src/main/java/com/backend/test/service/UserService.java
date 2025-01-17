package com.backend.test.service;

import com.backend.test.dto.UserDto;
import com.backend.test.entity.UserEntity;
import com.backend.test.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(user -> new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        )).collect(Collectors.toList());
    }
}
