package com.example.demo.src.coupon.model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class GetCouponRes {
    private Long idx;
    private String name;
    private int order;
    private String discountType;
    private float discount;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private String couponType;
    private LocalDate availableStartDate;
    private LocalDate availableEndDate;
    private int minimumPrice;
    private String status;

    public GetCouponRes(Coupon entity) {
        this.idx = entity.getIdx();
        this.name = entity.getName();
        this.order = entity.getOrder();
        this.discountType = entity.getDiscountType();
        this.startDate = entity.getStartDate();
        this.endDate = entity.getEndDate();
        this.description = entity.getDescription();
        this.couponType = entity.getCouponType();
        this.availableStartDate = entity.getAvailableStartDate();
        this.availableEndDate = entity.getAvailableEndDate();
        this.minimumPrice = entity.getMinimumPrice();
        this.status = entity.getStatus();

    }
}
