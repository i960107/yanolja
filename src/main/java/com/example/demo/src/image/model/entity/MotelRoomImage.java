package com.example.demo.src.image.model.entity;

import com.example.demo.config.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class MotelRoomImage extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private Long roomIdx;

    @Column
    private Long imageIdx;

    @Column
    private byte order;

    @Column
    private String status;

    @Builder
    public MotelRoomImage(Long roomIdx, Long imageIdx, byte order, String status) {
        this.roomIdx = roomIdx;
        this.imageIdx = imageIdx;
        this.order = order;
        this.status = status;
    }
}
