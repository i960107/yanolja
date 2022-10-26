package com.example.demo.src.payment.model;

import com.example.demo.config.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Payment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private Long bookingIdx;

    @Column
    private int originalPrice;

    @Column
    private int discountedPrice;

    @Column
    private int totalPrice;

    @Column
    private String status;

    @Builder
    public Payment(Long bookingIdx, int originalPrice, int discountedPrice, int totalPrice, String status) {
        this.bookingIdx = bookingIdx;
        this.originalPrice = originalPrice;
        this.discountedPrice = discountedPrice;
        this.totalPrice = totalPrice;
        this.status = status;
    }

}
