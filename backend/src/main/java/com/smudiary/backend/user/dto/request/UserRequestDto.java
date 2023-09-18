package com.smudiary.backend.user.dto.request;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserRequestDto implements Serializable {
    private String name;
    private String username;
    private String password;
    private LocalDate birth;
    private String email;
}
