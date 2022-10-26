package com.example.demo.src.image.model.entity;

import com.example.demo.config.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class MotelImage extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private Long motelIdx;

    @Column
    private Long imageIdx;

    @Column
    private byte order;

    @Column
    private String status;

    @Builder
    public MotelImage(Long motelIdx, Long imageIdx, byte order, String status) {
        this.motelIdx = motelIdx;
        this.imageIdx = imageIdx;
        this.order = order;
        this.status = status;
    }
}
