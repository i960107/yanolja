package com.example.demo.src.motel.model;

import lombok.Getter;

import java.sql.Time;
import java.time.LocalTime;

@Getter
public class GetMotelRes {
    private Long idx;
    private String name;
    private Long regionIdx;
    private float x;
    private float y;
    private String kakaoPlaceId;
    private String location;
    private String roadAddressName;
    private String addressDetail;
    private String thumbnailImageUrl;
    private String description;
    private String facility;
    private String notice;
    private String phone;
    private String event;
    private float rating;
    private int reviewCount;
    private int daytimeOriginalPrice;
    private byte daytimeDiscount;
    private int daytimeSalePrice;
    private int sleepOverOriginalPrice;
    private byte sleepOverDiscount;
    private int sleepOverSalePrice;
    private byte maxPeople;
    private byte daytimeDuration;
    private String daytimeAvailableHour;
    private LocalTime checkInTime;
    private String status;

    public GetMotelRes(Motel entity) {
        this.idx = entity.getIdx();
        this.name = entity.getName();
        this.regionIdx = entity.getRegionIdx();
        this.x = entity.getX();
        this.y = entity.getY();
        this.kakaoPlaceId = entity.getKakaoPlaceId();
        this.location = entity.getLocation();
        this.roadAddressName = entity.getRoadAddressName();
        this.addressDetail = entity.getAddressDetail();
        this.thumbnailImageUrl = entity.getThumbnailImageUrl();
        this.description = entity.getDescription();
        this.facility = entity.getFacility();
        this.notice = entity.getNotice();
        this.phone = entity.getPhone();
        this.event = entity.getEvent();
        this.rating = entity.getRating();
        this.reviewCount = entity.getReviewCount();
        this.daytimeAvailableHour = entity.getDaytimeAvailableHour();
        this.daytimeOriginalPrice = entity.getDaytimeOriginalPrice();
        this.daytimeDiscount = entity.getDaytimeDiscount();
        this.daytimeSalePrice = entity.getDaytimeSalePrice();
        this.sleepOverSalePrice = entity.getSleepOverSalePrice();
        this.sleepOverDiscount = entity.getSleepOverDiscount();
        this.sleepOverOriginalPrice = entity.getSleepOverOriginalPrice();
        this.maxPeople = entity.getMaxPeople();
        this.checkInTime = entity.getCheckInTime();
        this.status = entity.getStatus();
    }

}
