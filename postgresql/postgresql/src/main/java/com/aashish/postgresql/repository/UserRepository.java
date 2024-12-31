package com.aashish.postgresql.repository;

import com.aashish.postgresql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
