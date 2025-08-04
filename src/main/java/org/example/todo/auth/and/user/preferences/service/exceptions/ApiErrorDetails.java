package org.example.todo.auth.and.user.preferences.service.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record ApiErrorDetails(
        @JsonInclude(JsonInclude.Include.NON_NULL) String pointer,
        String reason
) implements Serializable {
}