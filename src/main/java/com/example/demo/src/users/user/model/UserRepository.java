package com.example.demo.src.users.user.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndSnsProviderAndStatus(String email, String snsProvider, String status);

    Optional<User> findByIdxAndRefreshTokenAndStatus(Long idx, String refreshToken, String status);

    Optional<User> findByEmailAndStatus(String email, String status);

    Optional<User> findByIdAndStatus(String id, String status);


}

