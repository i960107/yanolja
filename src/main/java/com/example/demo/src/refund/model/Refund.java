package com.example.demo.src.refund.model;

import com.example.demo.config.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Refund extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private Long paymentIdx;

    @Column
    private String status;

    @Builder
    public Refund(Long paymentIdx, String status) {
        this.paymentIdx = paymentIdx;
        this.status = status;
    }
}
