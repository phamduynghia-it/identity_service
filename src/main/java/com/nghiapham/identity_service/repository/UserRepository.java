package com.nghiapham.identity_service.repository;

import com.nghiapham.identity_service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByUsername(String Username);
    Optional<User> findByUsername(String Username);
}
