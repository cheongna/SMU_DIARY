package com.smudiary.backend.questions20.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuestionsResponseDto implements Serializable {
    private String mbti;

    private String favoriteFood;
}
