package com.smudiary.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiaryId implements Serializable {

    // 다이어리_ID
    private Long id;

    // 유저_ID
    private Long userId;
}
