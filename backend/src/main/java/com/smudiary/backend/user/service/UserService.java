package com.smudiary.backend.user.service;

import com.smudiary.backend.user.dto.request.UserLoginRequestDto;
import com.smudiary.backend.user.dto.request.UserProfileRequestDto;
import com.smudiary.backend.user.dto.request.UserRequestDto;
import com.smudiary.backend.user.dto.response.UserProfileResponseDto;
import com.smudiary.backend.user.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    //회원가입
    UserResponseDto create(UserRequestDto request);

    //전체조회
    List<UserResponseDto> getAll();

    //회원id로 조회
    UserResponseDto get(Long userId);

    //로그인 로직
    Long login(UserLoginRequestDto request);

    //이름과 이메일로 아이디 찾기
    String findUsernameByNameAndEmail(String name, String email);

    //아이디와 이메일로 비밀번호 찾기
    String findPasswordByUsernameAndEmail(String username, String email);

    //프로필 정보 가져오기
    UserProfileResponseDto getProfile(Long userId);

    //프로필 정보 업데이트
    UserProfileResponseDto updateProfile(Long userId, UserProfileRequestDto request);
}
