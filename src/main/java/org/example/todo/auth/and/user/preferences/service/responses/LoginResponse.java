package org.example.todo.auth.and.user.preferences.service.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private String emailId;
    private String fullName;
    private UUID userId;
}
