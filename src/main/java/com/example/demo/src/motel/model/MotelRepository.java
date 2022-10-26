package com.example.demo.src.motel.model;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MotelRepository extends JpaRepository<Motel,Long> {

//   @Query("select m from Motel m " +
//           "where m.idx in (select tag.accommodationIdx from AccommodationTag tag " +
//           "where tag.tagIdx = :tagIdx " +
//           "and tag.accommodationType = '모텔' " +
//           "and tag.status = 'ACTIVATED') " +
//           "and m.regionIdx = :regionIdx " +
//           "and m.maxPeople >= :people " +
//           "and m.status = 'ACTIVATED'")
//   List<Motel> findListBy(@Param("tagIdx") Long tagIdx,
//                          @Param("people") byte people,
//                          @Param("regionIdx") Long regionIdx,
//                          Sort sort);

   Optional<Motel> findByIdxAndStatus(Long idx, String status);
}
