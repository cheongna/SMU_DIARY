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

@Entity
@Table(name = "sticker")
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "is_deleted = false") // 삭제 안된것 가져오기
@SQLDelete(sql = "update `sticker` set `is_deleted` = true where `sticker_id` = ?") // 논리적 삭제 사용
@Builder
public class Sticker extends BaseEntity{

    // 스티커번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sticker_id", nullable = false)
    private Long stickerId;

    // 이름
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    // 설명
    @Column(name = "`explain`", length = 50)
    private String explain;

}
