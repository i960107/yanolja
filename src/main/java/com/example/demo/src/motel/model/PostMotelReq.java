package com.example.demo.src.motel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class PostMotelReq {
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
    private float rating = 0.0f;
    private int reviewCount = 0;
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
    private String status = "ACTIVATED";

    @Builder
    public PostMotelReq(String name, Long regionIdx, float x, float y, String kakaoPlaceId, String location, String roadAddressName, String addressDetail, String thumbnailImageUrl, String description, String facility, String notice, String phone, String event, int daytimeOriginalPrice, byte daytimeDiscount, int daytimeSalePrice, int sleepOverOriginalPrice, byte sleepOverDiscount, int sleepOverSalePrice, byte maxPeople, byte daytimeDuration, String daytimeAvailableHour, LocalTime checkInTime) {
        this.name = name;
        this.regionIdx = regionIdx;
        this.x = x;
        this.y = y;
        this.kakaoPlaceId = kakaoPlaceId;
        this.location = location;
        this.roadAddressName = roadAddressName;
        this.addressDetail = addressDetail;
        this.thumbnailImageUrl = thumbnailImageUrl;
        this.description = description;
        this.facility = facility;
        this.notice = notice;
        this.phone = phone;
        this.event = event;
        this.daytimeOriginalPrice = daytimeOriginalPrice;
        this.daytimeDiscount = daytimeDiscount;
        this.daytimeSalePrice = daytimeSalePrice;
        this.sleepOverOriginalPrice = sleepOverOriginalPrice;
        this.sleepOverDiscount = sleepOverDiscount;
        this.sleepOverSalePrice = sleepOverSalePrice;
        this.maxPeople = maxPeople;
        this.daytimeDuration = daytimeDuration;
        this.daytimeAvailableHour = daytimeAvailableHour;
        this.checkInTime = checkInTime;
    }

    public Motel toEntity() {
        return Motel.builder()
                .name(name)
                .regionIdx(regionIdx)
                .x(x)
                .y(y)
                .location(location)
                .kakaoPlaceId(kakaoPlaceId)
                .roadAddressName(roadAddressName)
                .addressDetail(addressDetail)
                .thumbnailImageUrl(thumbnailImageUrl)
                .description(description)
                .facility(facility)
                .notice(notice)
                .phone(phone)
                .event(event)
                .rating(rating)
                .maxPeople(maxPeople)
                .reviewCount(reviewCount)
                .daytimeOriginalPrice(daytimeOriginalPrice)
                .daytimeDiscount(daytimeDiscount)
                .daytimeSalePrice(daytimeSalePrice)
                .sleepOverOriginalPrice(sleepOverOriginalPrice)
                .sleepOverDiscount(sleepOverDiscount)
                .sleepOverSalePrice(sleepOverSalePrice)
                .daytimeDuration(daytimeDuration)
                .daytimeAvailableHour(daytimeAvailableHour)
                .checkInTime(checkInTime)
                .status(status)
                .build();
    }

}
