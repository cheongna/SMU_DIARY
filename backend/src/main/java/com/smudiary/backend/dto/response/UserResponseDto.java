package com.smudiary.backend.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserResponseDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private LocalDateTime createdAt;
}
