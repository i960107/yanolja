package com.example.demo.src.tag.model;

import com.example.demo.config.BaseTimeEntity;
import com.example.demo.config.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name="tag")
public class Tag extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idx;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String accommodationType;
    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Builder
    public Tag(String name,
               String description,
               String accommodationType,
               Status status) {
        this.name = name;
        this.description = description;
        this.accommodationType = accommodationType;
        this.status = status;
    }
}
