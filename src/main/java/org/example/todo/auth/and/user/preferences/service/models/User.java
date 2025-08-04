package org.example.todo.auth.and.user.preferences.service.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User{
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "email_id", nullable = false, unique = true)
    private String emailId;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        this.id = UUID.randomUUID();
        this.createdAt = LocalDateTime.now(ZoneOffset.UTC);
    }
}