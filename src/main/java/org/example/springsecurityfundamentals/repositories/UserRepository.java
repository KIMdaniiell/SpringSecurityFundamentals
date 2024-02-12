package org.example.springsecurityfundamentals.repositories;

import org.example.springsecurityfundamentals.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query ("""
        SELECT u FROM User u WHERE u.name = :name
    """)
    Optional<User> getUserByName(String name);
}
