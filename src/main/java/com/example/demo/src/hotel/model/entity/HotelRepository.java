package com.example.demo.src.hotel.model.entity;

import com.example.demo.config.Status;
import com.example.demo.src.hotel.model.entity.Hotel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

//    @Query(value = "select h from Hotel h " +
//            "where h.idx in " +
//            "(select acctag.accommodationIdx from AccommodationTag acctag " +
//            "where acctag.tagIdx = :tagIdx " +
//            "and acctag.accommodationType = '호텔') " +
//            "and h.regionIdx = :regionIdx " +
//            "and h.maxPeople >= :people "
//    )
    List<Hotel> findByMaxPeopleGreaterThanEqualAndRegionIdxIsAndStatus(
            @Param("people") byte people,
            @Param("regionIdx") long regionIdx,
            @Param("status") Status status,
            Sort sort);

    Optional<Hotel> findByIdxAndStatus(Long idx, Status status);

    Optional<Hotel> findByKakaoPlaceId(String kakaoPlaceId);

    @Query("select h from Hotel h join fetch AccommodationTag at ")
    Optional<Hotel> findByIdx(Long idx);
}
