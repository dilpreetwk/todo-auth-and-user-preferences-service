package org.example.todo.auth.and.user.preferences.service.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern.Flag;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.todo.auth.and.user.preferences.service.models.User;

@Data
public class SignupUserDto {
    @NotEmpty(message = "Full name is required")
    @Size(min = 2, max = 100, message = "Full name must be 2-100 characters long")
    private String fullName;

    @NotEmpty(message = "Email address is required")
    @Email(message = "Email address is invalid", flags = {Flag.CASE_INSENSITIVE})
    private String emailId;

    @NotEmpty(message = "Password is required")
    @Size(min = 8, max = 32, message = "Password must be 8–32 characters long")
    private String password;

    public User toUser() {
        User user = new User();
        user.setFullName(fullName);
        user.setEmailId(emailId);
        user.setPassword(password);
        return user;
    }
}