package com.smudiary.backend.questions20.controller;

import com.smudiary.backend.questions20.dto.request.QuestionsRequestDto;
import com.smudiary.backend.questions20.dto.response.QuestionsResponseDto;
import com.smudiary.backend.questions20.service.QuestionsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "20문답 컨트롤러")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/questions")
public class QuestionsController {
    private final QuestionsService questionsService;

    @Operation(summary = "20문답 가져오기")
    @GetMapping("/{userId}")
    public QuestionsResponseDto getQuestions_20(@PathVariable(value = "userId") Long userId) throws Exception {
        return questionsService.getQuestions(userId);
    }

    @Operation(summary = "20문답 값 수정하기")
    @PostMapping("/{userId}")
    public QuestionsResponseDto updateQuestions_20(@PathVariable(value = "userId") Long userId,
                                                   QuestionsRequestDto request) throws Exception {
        return questionsService.updateQuestions(userId, request);
    }
}
