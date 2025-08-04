package org.example.todo.auth.and.user.preferences.service.services;

import lombok.RequiredArgsConstructor;
import org.example.todo.auth.and.user.preferences.service.dtos.LoginUserDto;
import org.example.todo.auth.and.user.preferences.service.dtos.SignupUserDto;
import org.example.todo.auth.and.user.preferences.service.models.User;
import org.example.todo.auth.and.user.preferences.service.repositories.UserRepository;
import org.example.todo.auth.and.user.preferences.service.responses.LoginResponse;
import org.example.todo.auth.and.user.preferences.service.responses.SignupResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public SignupResponse signup(SignupUserDto signupUserDto) {
        signupUserDto.setPassword(passwordEncoder.encode(signupUserDto.getPassword()));
        User user = userRepository.save(signupUserDto.toUser());
        return new SignupResponse(user.getEmailId(), user.getFullName());
    }

    public LoginResponse login(LoginUserDto loginUserDto) {
        User user = userRepository.findByEmailId(loginUserDto.getEmailId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (!passwordEncoder.matches(loginUserDto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Incorrect password");
        }

        String token = jwtService.generateToken(user, user.getId());
        return new LoginResponse(token, user.getEmailId(), user.getFullName(), user.getId());
    }
}