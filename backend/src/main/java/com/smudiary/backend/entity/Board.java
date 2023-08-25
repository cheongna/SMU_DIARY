package com.smudiary.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@SQLDelete(sql = "update `board` set `is_deleted` = true where `id` = ?") // 논리적 삭제 사용
@Where(clause = "is_deleted = false")
@Entity(name = "`board`")
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id") // user_id를 외래키로 설정
    private User user;

    @Column(nullable = false, length = 50)
    private String title;

    @Lob
    private String content;
}
