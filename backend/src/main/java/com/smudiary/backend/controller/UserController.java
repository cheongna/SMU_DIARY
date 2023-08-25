package com.smudiary.backend.controller;

import com.smudiary.backend.dto.request.UserRequestDto;
import com.smudiary.backend.dto.response.UserResponseDto;
import com.smudiary.backend.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping("/")
    public UserResponseDto create(@RequestBody UserRequestDto request) {
        return userService.create(request);
    }

    @GetMapping("/")
    public List<UserResponseDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{UserId}")
    public UserResponseDto getUserById(@PathVariable Long UserId) {
        return userService.get(UserId);
    }
}
