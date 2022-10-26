package com.example.demo.src.hotel.model;

import com.example.demo.config.Status;
import com.example.demo.src.hotel.model.entity.Hotel;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class GetHotelRes {
    private Long idx;
    private String name;
    private Long regionIdx;
    private Float x;
    private Float y;
    private String kakaoPlaceId;
    private String location;
    private String roadAddressname;
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
    private int originalPrice;
    private byte discount;
    private int salePrice;
    private LocalTime checkInTime;
    private byte maxPeople;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Status status;

    public GetHotelRes(Hotel hotel) {
        this.idx = hotel.getIdx();
        this.name = hotel.getName();
        this.regionIdx = hotel.getRegionIdx();
        this.x = hotel.getX();
        this.y = hotel.getY();
        this.kakaoPlaceId = hotel.getKakaoPlaceId();
        this.location = hotel.getLocation();
        this.roadAddressname = hotel.getRoadAddressName();
        this.addressDetail = hotel.getAddressDetail();
        this.grade = hotel.getGrade();
        this.thumbnailImageUrl = hotel.getThumbnailImageUrl();
        this.description = hotel.getDescription();
        this.facility = hotel.getFacility();
        this.notice = hotel.getNotice();
        this.phone = hotel.getPhone();
        this.event = hotel.getEvent();
        this.rating = hotel.getRating();
        this.reviewCount = hotel.getReviewCount();
        this.originalPrice = hotel.getOriginalPrice();
        this.discount = hotel.getDiscount();
        this.salePrice = hotel.getSalePrice();
        this.checkInTime = hotel.getCheckInTime();
        this.maxPeople = hotel.getMaxPeople();
        this.createdAt = hotel.getCreatedAt();
        this.updatedAt = hotel.getUpdatedAt();
        this.status = hotel.getStatus();
    }
}
