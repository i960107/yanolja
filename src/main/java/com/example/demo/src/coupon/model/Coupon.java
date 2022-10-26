package com.example.demo.src.coupon.model;

import com.example.demo.config.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "coupon")
public class Coupon extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String name;

    @Column
    private int order;

    @Column
    private String discountType;

    @Column
    private float discount;

    @Column(columnDefinition = "DATE")
    private LocalDate startDate;

    @Column(columnDefinition = "DATE")
    private LocalDate endDate;

    @Column
    private String description;

    @Column
    private String couponType;

    @Column(columnDefinition = "DATE")
    private LocalDate availableStartDate;

    @Column(columnDefinition = "DATE")
    private LocalDate availableEndDate;

    @Column
    private int minimumPrice;

    @Column
    private String status;

    @Builder
    public Coupon(String name, int order, String discountType, float discount, LocalDate startDate, LocalDate endDate, String description, String couponType, LocalDate availableStartDate, LocalDate availableEndDate, int minimumPrice, String status) {
        this.name = name;
        this.order = order;
        this.discountType = discountType;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.couponType = couponType;
        this.availableStartDate = availableStartDate;
        this.availableEndDate = availableEndDate;
        this.minimumPrice = minimumPrice;
        this.status = status;
    }
}
