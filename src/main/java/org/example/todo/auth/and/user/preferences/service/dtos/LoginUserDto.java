package org.example.todo.auth.and.user.preferences.service.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern.Flag;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginUserDto {
    @NotEmpty(message = "Email address is required")
    @Email(message = "Email address is invalid", flags = {Flag.CASE_INSENSITIVE})
    private String emailId;

    @NotEmpty(message = "Password is required")
    @Size(min = 8, max = 32, message = "Password must be 8–32 characters long")
    private String password;
}