package com.smudiary.backend.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserLoginRequestDto implements Serializable {
    private String username;
    private String password;
}
