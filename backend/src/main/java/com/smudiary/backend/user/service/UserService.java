package com.smudiary.backend.user.service;

import com.smudiary.backend.user.dto.request.UserLoginRequestDto;
import com.smudiary.backend.user.dto.request.UserRequestDto;
import com.smudiary.backend.user.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto create(UserRequestDto request);

    List<UserResponseDto> getAll();

    UserResponseDto get(Long userId);

    Long login(UserLoginRequestDto request);
}
