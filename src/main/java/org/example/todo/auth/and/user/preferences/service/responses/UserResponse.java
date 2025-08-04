package org.example.todo.auth.and.user.preferences.service.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.todo.auth.and.user.preferences.service.models.User;

import java.util.UUID;

@Data
@AllArgsConstructor
public class UserResponse {
    private UUID id;
    private String emailId;
    private String fullName;

    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmailId(),
                user.getFullName()
        );
    }
}
