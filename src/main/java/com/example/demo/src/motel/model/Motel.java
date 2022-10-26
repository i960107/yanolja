package com.example.demo.src.motel.model;

import com.example.demo.config.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
@Table(name ="motel")
public class Motel extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String name;

    @Column
    private Long regionIdx;

    @Column
    private float x;

    @Column
    private float y;

    @Column
    private String kakaoPlaceId;

    @Column
    private String location;

    @Column
    private String roadAddressName;

    @Column
    private String addressDetail;

    @Column
    private String thumbnailImageUrl;

    @Column
    private String description;

    @Column
    private String facility;

    @Column
    private String notice;

    @Column
    private String phone;

    @Column
    private String event;

    @Column
    private float rating;

    @Column
    private int reviewCount;

    @Column
    private int daytimeOriginalPrice;

    @Column
    private byte daytimeDiscount;

    @Column
    private int daytimeSalePrice;

    @Column
    private int sleepOverOriginalPrice;

    @Column
    private byte sleepOverDiscount;

    @Column
    private int sleepOverSalePrice;

    @Column
    private byte maxPeople;

    @Column
    private byte daytimeDuration;

    @Column
    private String daytimeAvailableHour;

    @Column
    private LocalTime checkInTime;

    @Column
    private String status;

    @Builder
    public Motel(String name, Long regionIdx, float x, float y, String kakaoPlaceId,
                 String location, String roadAddressName, String addressDetail,
                 String thumbnailImageUrl, String description, String facility,
                 String notice, String phone, String event, float rating,
                 int reviewCount, int daytimeOriginalPrice, byte daytimeDiscount,
                 int daytimeSalePrice, int sleepOverOriginalPrice,
                 byte sleepOverDiscount, int sleepOverSalePrice, byte maxPeople,
                 byte daytimeDuration, String daytimeAvailableHour, LocalTime checkInTime,
                 String status) {

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
        this.rating = rating;
        this.reviewCount = reviewCount;
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
        this.status = status;
    }
}



