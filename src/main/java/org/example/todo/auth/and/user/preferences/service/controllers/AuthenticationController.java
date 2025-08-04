package org.example.todo.auth.and.user.preferences.service.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.todo.auth.and.user.preferences.service.dtos.LoginUserDto;
import org.example.todo.auth.and.user.preferences.service.dtos.SignupUserDto;
import org.example.todo.auth.and.user.preferences.service.responses.LoginResponse;
import org.example.todo.auth.and.user.preferences.service.responses.SignupResponse;
import org.example.todo.auth.and.user.preferences.service.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginUserDto loginUserDto) {
        LoginResponse loginResponse = authenticationService.login(loginUserDto);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signup(@Valid @RequestBody SignupUserDto signupUserDto) {
        SignupResponse signupResponse = authenticationService.signup(signupUserDto);
        return ResponseEntity.ok(signupResponse);
    }
}
