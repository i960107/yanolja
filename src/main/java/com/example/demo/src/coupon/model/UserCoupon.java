package com.example.demo.src.coupon.model;

import com.example.demo.config.BaseTimeEntity;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name="user_coupon")
public class UserCoupon extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private Long userIdx;

    @Column
    private Long couponIdx;

    @Column
    private String status;
}
