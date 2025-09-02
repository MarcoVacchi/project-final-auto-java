package org.lessons.java.project_final_auto_java.repository;

import java.util.Optional;

import org.lessons.java.project_final_auto_java.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
