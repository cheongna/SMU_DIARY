package com.smudiary.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "questions_20")
@Getter
@DynamicInsert
@DynamicUpdate
@Where(clause = "is_deleted = false") // 삭제 안된것 가져오기
@SQLDelete(sql = "update `questions_20` set `is_deleted` = true where `questions_id` = ?") // 논리적 삭제 사용
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Questions20 extends BaseEntity {

    // 20문답_아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questions_id", nullable = false)
    private Long questionsId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 당신의 mbti는?
    @Setter
    @Column(name = "mbti", length = 4)
    private String mbti;

    @Setter
    @Column(name = "favorite_food", length = 10)
    private String favoriteFood;
}
