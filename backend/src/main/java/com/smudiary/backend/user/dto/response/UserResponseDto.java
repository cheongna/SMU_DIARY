package com.smudiary.backend.user.dto.response;

import lombok.*;

import java.time.LocalDate;
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
    private LocalDate birth;
    private String email;
    private LocalDateTime createdAt;
}
