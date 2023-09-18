package com.smudiary.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;

@Entity
@Table(name = "profile")
@Getter
@DynamicInsert
@DynamicUpdate
@Where(clause = "is_deleted = false") // 삭제 안된것 가져오기
@SQLDelete(sql = "update `profile` set `is_deleted` = true where `user_id` = ?") // 논리적 삭제 사용
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile extends BaseEntity {

    // 유저_ID
    @Id
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Setter
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 20문답_번호
    @Column(name = "questions_id", nullable = true)
    private Long questionsId;

    // 유저_닉네임
    @Column(name = "user_nickname", length = 20)
    private String userNickname;

    // 유저_생일
    @Column(name = "user_birthday")
    private LocalDate userBirthday;

    // 유저_이메일
    @Column(name = "user_email", length = 50)
    private String userEmail;

    // 좌우명
    @Column(name = "motto")
    private String motto;

}
