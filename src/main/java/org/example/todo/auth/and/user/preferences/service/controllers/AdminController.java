package org.example.todo.auth.and.user.preferences.service.controllers;

import lombok.RequiredArgsConstructor;
import org.example.todo.auth.and.user.preferences.service.responses.UserResponse;
import org.example.todo.auth.and.user.preferences.service.services.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/getAll")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(adminService.getAllUsers());
    }
}
