package com.smudiary.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Where(clause = "is_deleted = false") // 삭제 안된것 가져오기
@SQLDelete(sql = "update `user` set `is_deleted` = true where `id` = ?") // 논리적 삭제 사용
@Entity(name = "`user`")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, length = 20)
    private String username;

    @Column(nullable = false, length = 30)
    private String password;

    @Column(nullable = true, length = 50)
    private String email;

    private LocalDate lastLoginDate;

}
