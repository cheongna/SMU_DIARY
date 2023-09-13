package com.smudiary.backend.controller;

import com.smudiary.backend.user.dto.request.UserLoginRequestDto;
import com.smudiary.backend.user.dto.request.UserRequestDto;
import com.smudiary.backend.user.dto.response.UserResponseDto;
import com.smudiary.backend.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
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

    @PostMapping("/login")
    public Long login(@RequestBody UserLoginRequestDto request) {
        return userService.login(request);
    }
}
