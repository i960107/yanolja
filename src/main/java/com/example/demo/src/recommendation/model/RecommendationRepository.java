package com.example.demo.src.recommendation.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation,Long> {
    List<Recommendation> findByAccommodationTypeAndAccommodationIdxAndStatus(String accommodationType, Long accommodationIdx, String status);
}
