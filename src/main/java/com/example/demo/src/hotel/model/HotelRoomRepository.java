package com.example.demo.src.hotel.model;

import com.example.demo.src.hotel.model.entity.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HotelRoomRepository extends JpaRepository<HotelRoom,Long> {

    List<HotelRoom> findByHotelIdxAndStatusOrderByOrderAsc(Long hotelIdx,String status);
    Optional<HotelRoom> findByIdxAndStatusOrderByOrderAsc(Long idx, String status);

}
