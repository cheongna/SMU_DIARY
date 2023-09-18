package com.smudiary.backend.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserProfileRequestDto {
    private String nickname;
    private LocalDate birth;
    private String email;
    private String motto;
}
