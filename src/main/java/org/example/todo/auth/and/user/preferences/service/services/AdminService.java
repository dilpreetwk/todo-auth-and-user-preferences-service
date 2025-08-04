package org.example.todo.auth.and.user.preferences.service.services;

import lombok.RequiredArgsConstructor;
import org.example.todo.auth.and.user.preferences.service.models.User;
import org.example.todo.auth.and.user.preferences.service.repositories.UserRepository;
import org.example.todo.auth.and.user.preferences.service.responses.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(UserResponse::from)
                .toList();
    }
}
