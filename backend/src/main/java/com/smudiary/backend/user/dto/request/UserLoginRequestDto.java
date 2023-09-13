package com.smudiary.backend.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class UserLoginRequestDto implements Serializable {
    private String username;
    private String password;
}
