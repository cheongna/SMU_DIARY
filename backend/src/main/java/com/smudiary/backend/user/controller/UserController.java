package com.smudiary.backend.user.controller;

import com.smudiary.backend.user.dto.request.UserLoginRequestDto;
import com.smudiary.backend.user.dto.request.UserRequestDto;
import com.smudiary.backend.user.dto.response.UserResponseDto;
import com.smudiary.backend.user.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "유저 컨트롤러")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@SecurityRequirement(name = "BasicAuth")
public class UserController {
    private final UserServiceImpl userService;


    @Operation(summary = "회원가입")
    @PostMapping("/join") //회원가입 컨트롤러, responseDto 반환
    public UserResponseDto create(@RequestBody UserRequestDto request) {
        return userService.create(request);
    }

    @Operation(summary = "전체 회원 조회")
    @GetMapping("/")
    public List<UserResponseDto> getAll() {
        return userService.getAll();
    }

    @Operation(summary = "회원 id로 회원 조회")
    @GetMapping("/{UserId}")
    public UserResponseDto getUserById(@PathVariable Long UserId) {
        return userService.get(UserId);
    }

    @Operation(summary = "로그인 처리")
    @PostMapping("/login")
    public Long login(@RequestBody UserLoginRequestDto request) {
        return userService.login(request);
    }

    @Operation(summary = "이름과 email로 아이디 찾기")
    @PostMapping("/findUsername") //
    public String findUsernameByNameAndEmail(@RequestParam("name") String name, @RequestParam("email") String email) {
        return userService.findUsernameByNameAndEmail(name, email);
    }

    @Operation(summary = "아이디와 email로 비밀번호 찾기")
    @PostMapping("/findPassword")
    public String findPasswordByUsernameAndEmail(@RequestParam("username") String username, @RequestParam("email") String email) {
        return userService.findPasswordByUsernameAndEmail(username, email);
    }
}
