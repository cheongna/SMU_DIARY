package com.smudiary.backend.service;

import com.smudiary.backend.dto.request.UserRequestDto;
import com.smudiary.backend.dto.response.UserResponseDto;
import com.smudiary.backend.entity.User;
import com.smudiary.backend.repository.UserRepository;
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
        if (request == null) try {
            throw new Exception();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

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
    public List<UserResponseDto> getAll() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(user -> modelMapper.map(user, UserResponseDto.class))
                .collect(Collectors.toList());
    }

}
