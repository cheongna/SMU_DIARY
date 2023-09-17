package com.smudiary.backend.questions20.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class QuestionsRequestDto implements Serializable {
    private String mbti;
    private String favoriveFood;
}
