package com.example.demo.src.region.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Long> {
    List<Region> findByStatusOrderByIdxAsc(String status);
}
