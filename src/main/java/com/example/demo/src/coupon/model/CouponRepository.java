package com.example.demo.src.coupon.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon,Long> {
    @Query("select c from Coupon c " +
            "where c.idx in (select uc.couponIdx from UserCoupon uc " +
            "where uc.userIdx = :userIdx and uc.status = 'ACTIVATED' ) " +
            "and c.status = 'ACTIVATED' " +
            "order by idx asc")
    List<Coupon> findListByUserIdx(@Param("userIdx") Long userIdx);
}
