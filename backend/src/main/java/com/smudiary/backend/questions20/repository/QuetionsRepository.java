package com.smudiary.backend.questions20.repository;

import com.smudiary.backend.entity.Questions20;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuetionsRepository extends JpaRepository<Questions20, Long> {
    Questions20 findByUserId(Long userId);
}
