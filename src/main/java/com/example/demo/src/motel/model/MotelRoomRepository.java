package com.example.demo.src.motel.model;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MotelRoomRepository extends JpaRepository<MotelRoom, Long> {

    List<MotelRoom> findByMotelIdxAndStatusOrderByOrderAsc(Long motelIdx,String status);

    Optional<MotelRoom> findByIdxAndMotelIdxAndStatus(Long idx, Long motelIdx, String status);
}
