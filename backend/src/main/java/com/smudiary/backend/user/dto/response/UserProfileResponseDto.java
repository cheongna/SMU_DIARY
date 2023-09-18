package com.smudiary.backend.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserProfileResponseDto {
    private String nickname;
    private LocalDate birth;
    private String email;
    private String motto;
}
