package com.example.demo.src.image.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;

    @Column
    private String imageUrl;

    @Builder
    public Image(long idx, String imageUrl) {
        this.idx = idx;
        this.imageUrl = imageUrl;
    }
}
