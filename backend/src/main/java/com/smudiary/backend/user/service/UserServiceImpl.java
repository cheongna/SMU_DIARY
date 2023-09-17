package com.smudiary.backend.user.service;

import com.smudiary.backend.entity.User;
import com.smudiary.backend.user.dto.request.UserLoginRequestDto;
import com.smudiary.backend.user.dto.request.UserProfileRequestDto;
import com.smudiary.backend.user.dto.request.UserRequestDto;
import com.smudiary.backend.user.dto.response.UserProfileResponseDto;
import com.smudiary.backend.user.dto.response.UserResponseDto;
import com.smudiary.backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto create(UserRequestDto request) {
        var encodedPassword = passwordEncoder.encode(request.getPassword());
        request.setPassword(encodedPassword);
        User entity = modelMapper.map(request, User.class);
        userRepository.save(entity);
        return modelMapper.map(entity, UserResponseDto.class);
    }

    @Override
    public UserResponseDto get(Long userId) {
        User entity = userRepository.findById(userId).orElseThrow();
        return modelMapper.map(entity, UserResponseDto.class);
    }

    @Override
    public Long login(UserLoginRequestDto request) {
        var user = userRepository.findByUsername(request.getUsername());
        if (user.isPresent()) {
            if (user.get().getPassword().equals(request.getPassword())) {
                return 1L;
            } else {
                throw new RuntimeException("아이디 혹은 비밀번호가 존재하지 않습니다.");
            }
        } else {
            throw new RuntimeException("존재하지 않는 아이디 입니다.");
        }
    }

    @Override
    public String findUsernameByNameAndEmail(String name, String email) { //아이디를 잊어버렸을때
        var user = userRepository.findByNameAndEmail(name, email);
        if (user.isPresent()) {//유저가 존재하면
            return user.get().getUsername();
        } else {
            return "이름 혹은 이메일이 유효하지 않습니다.";
        }
    }

    @Override
    public String findPasswordByUsernameAndEmail(String username, String email) {
        var user = userRepository.findByUsernameAndEmail(username, email);
        return user.map(User::getPassword).orElse("아이디 혹은 이메일이 일치하지 않습니다.");
    }

    //프로필 정보 업데이트
    @Override
    public UserProfileResponseDto updateProfile(Long userId, UserProfileRequestDto request) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setNickname(request.getNickname());
        user.setBirth(request.getBirth());
        user.setEmail(request.getEmail());
        user.setMotto(request.getMotto());
        User updatedUser = userRepository.save(user);
        return modelMapper.map(updatedUser, UserProfileResponseDto.class);
    }

    //프로필 정보 가져오기
    @Override
    public UserProfileResponseDto getProfile(Long userId) {
        var user = userRepository.findById(userId).orElseThrow();
        log.info(user.getNickname());
        var response = modelMapper.map(user, UserProfileResponseDto.class);
        log.info(response.getNickname());
        return response;
    }

    @Override
    public List<UserResponseDto> getAll() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(user -> modelMapper.map(user, UserResponseDto.class))
                .collect(Collectors.toList());
    }

}
