package com.smudiary.backend.user.service;

import com.smudiary.backend.entity.User;
import com.smudiary.backend.user.dto.request.UserLoginRequestDto;
import com.smudiary.backend.user.dto.request.UserRequestDto;
import com.smudiary.backend.user.dto.response.UserResponseDto;
import com.smudiary.backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserResponseDto create(UserRequestDto request) {
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
    public List<UserResponseDto> getAll() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(user -> modelMapper.map(user, UserResponseDto.class))
                .collect(Collectors.toList());
    }

}
