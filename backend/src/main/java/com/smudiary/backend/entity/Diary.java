package com.smudiary.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;

@Entity
@Table(name = "diary")
@Getter
@DynamicInsert
@DynamicUpdate
@Where(clause = "is_deleted = false") // 삭제 안된것 가져오기
@SQLDelete(sql = "update `diary` set `is_deleted` = true where `id` = ?") // 논리적 삭제 사용
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(DiaryId.class)
public class Diary extends BaseEntity {


    // 다이어리_ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // 유저_ID
    @Id
    @Column(name = "user_id", nullable = false)
    private Long userId;

    // 오늘_날짜
    @Column(name = "today_date")
    private LocalDate todayDate;

    // 오늘의_기분
    @Column(name = "today_feel", length = 2)
    private String todayFeel;

    // 제목
    @Column(name = "title", length = 10)
    private String title;

    // 본문
    @Column(name = "content")
    @Lob
    private String content;

    // 사진
    @Column(name = "picture")
    private String picture;

    // 좋아요
    @Column(name = "like_count")
    private Long likeCount;


    // 공개여부
    @Column(name = "is_private")
    private Boolean isPrivate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "sticker_id")
    private Sticker sticker;

}
