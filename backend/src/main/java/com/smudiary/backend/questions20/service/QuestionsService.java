package com.smudiary.backend.questions20.service;

import com.smudiary.backend.questions20.dto.request.QuestionsRequestDto;
import com.smudiary.backend.questions20.dto.response.QuestionsResponseDto;

public interface QuestionsService {
    QuestionsResponseDto getQuestions(Long userId) throws Exception;
    QuestionsResponseDto updateQuestions(Long userId, QuestionsRequestDto request) throws Exception;
}
