package com.example.demo.src.image.model.entity;

import com.example.demo.config.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class HotelRoomImage extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private Long roomIdx;

    @Column
    private Long imageIdx;

    @Column
    private String status;

    @Builder
    public HotelRoomImage(Long roomIdx, Long imageIdx, String status) {
        this.roomIdx = roomIdx;
        this.imageIdx = imageIdx;
        this.status = status;
    }
}
