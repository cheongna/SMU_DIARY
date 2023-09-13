package com.smudiary.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;
import org.springframework.context.annotation.DependsOn;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@Where(clause = "is_deleted = false") // 삭제 안된것 가져오기
@SQLDelete(sql = "update `user` set `is_deleted` = true where `id` = ?") // 논리적 삭제 사용
@Entity(name = "`user`")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false, length = 20)
    @OrderColumn
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    //null이 가능하도록 변경 회원가입 시에 닉네임까지 필수로
    //설정하는건 추후 validation 설정 후에 변경
    @Column(nullable = true, length = 20)
    private String nickname;

    @Column(nullable = false)
    private LocalDate birth;

    //email은 반드시 입력하도록 변경
    @Column(nullable = false, length = 50)
    private String email;

}
