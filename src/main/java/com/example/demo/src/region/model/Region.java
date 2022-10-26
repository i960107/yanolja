package com.example.demo.src.region.model;

import com.example.demo.config.BaseTimeEntity;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name="region")
public class Region extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String regionDepth1;

    @Column
    private String regionDepth2;

    @Column
    private String status;

    @Builder
    public Region(String regionDepth1, String regionDepth2, String status) {
        this.regionDepth1 = regionDepth1;
        this.regionDepth2 = regionDepth2;
        this.status = status;
    }
}
