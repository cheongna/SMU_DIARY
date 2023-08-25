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
@SQLDelete(sql = "update `comment` set `is_deleted` = true where `id` = ?") //논리적 삭제 사용
@Where(clause = "is_deleted = false") // 삭제 안된것만 가져옴
@Entity(name = "`comment`")
public class Comment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id") // 외래키 user_id로 설정
    private User user;

    @ManyToOne
    @JoinColumn(name = "board_id") // 외래키 board_id로 설정
    private Board board;

    @Column(nullable = false, length = 50)
    private String content;
}
