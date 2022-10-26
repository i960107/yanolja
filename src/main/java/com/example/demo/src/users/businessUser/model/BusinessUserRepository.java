package com.example.demo.src.users.businessUser.model;

import com.example.demo.config.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface BusinessUserRepository extends JpaRepository<BusinessUser, Long> {

    Optional<BusinessUser> findByIdAndStatus(String id, Status status);

    Optional<BusinessUser> findByEmailAndStatus(String email, Status status);

    Optional<BusinessUser> findByPhoneAndStatus(String phone, Status status);

    Optional<BusinessUser> findByIdxAndStatus(Long userIdx, Status status);

    Optional<BusinessUser> findByIdxAndAccommodationTypeAndAccommodationIdxAndStatus(Long idx, String accommodationType, Long accommodationIdx, Status status);
}
