package com.smudiary.backend.user.service;

import com.smudiary.backend.entity.User;
import com.smudiary.backend.user.dto.request.UserLoginRequestDto;
import com.smudiary.backend.user.dto.request.UserRequestDto;
import com.smudiary.backend.user.dto.response.UserResponseDto;
import com.smudiary.backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
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

    @Override
    public List<UserResponseDto> getAll() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(user -> modelMapper.map(user, UserResponseDto.class))
                .collect(Collectors.toList());
    }

}
