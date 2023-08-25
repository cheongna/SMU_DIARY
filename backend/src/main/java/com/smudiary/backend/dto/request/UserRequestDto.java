package com.smudiary.backend.dto.request;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserRequestDto implements Serializable {
    private String username;
    private String password;
    private String email;
}
