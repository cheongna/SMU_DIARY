package com.smudiary.backend.service;

import com.smudiary.backend.dto.request.UserRequestDto;
import com.smudiary.backend.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto create(UserRequestDto request);

    List<UserResponseDto> getAll();

    UserResponseDto get(Long userId);
}
