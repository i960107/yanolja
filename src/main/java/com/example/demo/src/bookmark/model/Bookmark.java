package com.example.demo.src.bookmark.model;

import com.example.demo.config.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "bookmark")
public class Bookmark extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private Long userIdx;

    @Column
    private String accommodationType;

    @Column
    private Long accommodationIdx;

    @Column
    private String status;

    @Builder
    public Bookmark(Long userIdx, String accommodationType, Long accommodationIdx, String status) {
        this.userIdx = userIdx;
        this.accommodationType = accommodationType;
        this.accommodationIdx = accommodationIdx;
        this.status = status;
    }
}
