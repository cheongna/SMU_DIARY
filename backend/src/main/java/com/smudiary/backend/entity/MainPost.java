package com.smudiary.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "main_post")
@Getter
@Setter
@NoArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
@Where(clause = "is_deleted = false") // 삭제 안된것 가져오기
@SQLDelete(sql = "update `main_post` set `is_deleted` = true where `post_id` = ?") // 논리적 삭제 사용
@AllArgsConstructor
public class MainPost extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 메인사진주소
    @Column(name = "main_picture")
    @Setter
    private String mainPicture;

    // 메인페이지_소개글
    @Column(name = "post_intro", length = 20)
    @Setter
    private String postIntro;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
