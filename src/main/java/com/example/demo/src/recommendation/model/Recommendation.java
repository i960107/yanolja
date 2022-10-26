package com.example.demo.src.recommendation.model;

import com.example.demo.config.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "recommendation")
public class Recommendation extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String accommodationType;

    @Column
    private Long accommodationIdx;

    @Column
    private Long recommendationIdx;

    @Column
    private String status;

    @Builder
    public Recommendation(String accommodationType,
                          Long accommodationIdx,
                          Long recommendationIdx,
                          String status) {
        this.accommodationType = accommodationType;
        this.accommodationIdx = accommodationIdx;
        this.recommendationIdx = recommendationIdx;
        this.status = status;
    }
}
