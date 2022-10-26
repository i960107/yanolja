package com.example.demo.src.image.model.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelImageRepository extends JpaRepository<HotelImage,Long> {
}
