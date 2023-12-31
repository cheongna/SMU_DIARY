package com.smudiary.backend.user.repository;

import com.smudiary.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByNameAndEmail(String name, String email);

    Optional<User> findByUsernameAndEmail(String username, String email);
}
