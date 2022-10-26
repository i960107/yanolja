package com.example.demo.src.tag.model;

import com.example.demo.config.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag,Long> {

    List<Tag> findByAccommodationTypeAndStatus(
            String AccommodationType,
            String status
    );

    Optional<Tag> findByIdxAndStatus(Long tagIdx, Status status);
}
