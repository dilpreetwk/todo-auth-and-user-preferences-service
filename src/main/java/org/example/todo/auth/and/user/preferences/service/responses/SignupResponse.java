package org.example.todo.auth.and.user.preferences.service.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignupResponse {
    private String emailId;
    private String fullName;
}