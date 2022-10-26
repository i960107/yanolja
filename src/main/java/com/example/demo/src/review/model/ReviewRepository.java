package com.example.demo.src.review.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("select r from Review r " +
            "where r.accommodationType = '호텔' " +
            "and r.accommodationIdx = :hotelIdx " +
            "and status = 'ACTIVATED' " +
            "order by createdAt desc ")
    List<Review> findByHotelIdx(Long hotelIdx);

    @Query("select r from Review r " +
            "where r.accommodationType = '모텔' " +
            "and r.accommodationIdx = :motelIdx " +
            "and status = 'ACTIVATED' " +
            "order by createdAt desc")
    List<Review> findByMotelIdx(Long motelIdx);

//    @Query(nativeQuery = true)
//    GetRatingRes findRating(@Param("accommodationType") String accommodationType, @Param("accommodationIdx") Long accommodationIdx);
}
