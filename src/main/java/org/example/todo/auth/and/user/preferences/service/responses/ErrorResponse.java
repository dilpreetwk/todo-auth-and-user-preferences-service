package org.example.todo.auth.and.user.preferences.service.responses;

import lombok.Builder;
import org.example.todo.auth.and.user.preferences.service.exceptions.ApiErrorDetails;

import java.util.List;

@Builder
public record ErrorResponse(
        String code,
        String title,
        List<ApiErrorDetails> errors
) {
}