package com.example.demo.src.hotel.model;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class PatchHotelReq {
    private Long idx;
    private String name;
    private Long regionIdx;
    private Float x;
    private Float y;
    private String kakaoPlaceId;
    private String location;
    private String addressDetail;
    private String grade;
    private String thumbnailImageUrl;
    private String description;
    private String facility;
    private String notice;
    private String phone;
    private String event;
    private float rating;
    private int reviewCount;
    private byte maxPeople;
    private int originalPrice;
    private byte discount;
    private int salePrice;
    private LocalTime checkInTime;
    private Boolean verified;
    private LocalDateTime updatedAt;
    private String status;

}
