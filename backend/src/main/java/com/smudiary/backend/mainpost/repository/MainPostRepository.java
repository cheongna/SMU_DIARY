package com.smudiary.backend.mainpost.repository;

import com.smudiary.backend.entity.MainPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainPostRepository extends JpaRepository<MainPost, Long> {
    MainPost findByUserId(Long userId);
}
