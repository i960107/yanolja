package com.example.demo.src.booking.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findByUserIdxAndStatusOrderByCreatedAtDesc(Long userIdx,String status);

}
