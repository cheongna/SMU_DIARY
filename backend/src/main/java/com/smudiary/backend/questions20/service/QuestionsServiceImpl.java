package com.smudiary.backend.questions20.service;

import com.smudiary.backend.entity.Questions20;
import com.smudiary.backend.questions20.dto.request.QuestionsRequestDto;
import com.smudiary.backend.questions20.dto.response.QuestionsResponseDto;
import com.smudiary.backend.questions20.repository.QuetionsRepository;
import com.smudiary.backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionsServiceImpl implements QuestionsService {
    private final QuetionsRepository quetionsRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public QuestionsResponseDto getQuestions(Long userId) throws Exception {
        var questions = quetionsRepository.findByUserId(userId);
        var user = userRepository.findById(userId);
        if (questions == null) {
            if (user.isEmpty()) {
                throw new Exception("존재하지 않는 Id입니다.");
            } else {
                //질문 추가되면 추가
                var question = Questions20.builder()
                        .user(user.get())
                        .mbti("")
                        .favoriteFood("")
                        .build();
                var savedQuestions = quetionsRepository.save(question);
                return modelMapper.map(savedQuestions, QuestionsResponseDto.class);
            }
        }
        return modelMapper.map(questions, QuestionsResponseDto.class);
    }

    @Override
    public QuestionsResponseDto updateQuestions(Long userId, QuestionsRequestDto request) throws Exception {
        var questions = quetionsRepository.findByUserId(userId);
        if (questions == null) throw new Exception("존재하지 않는 유저입니다.");
        questions.setMbti(request.getMbti());
        questions.setFavoriteFood(request.getFavoriveFood());
        quetionsRepository.save(questions);
        return modelMapper.map(questions, QuestionsResponseDto.class);
    }
}
