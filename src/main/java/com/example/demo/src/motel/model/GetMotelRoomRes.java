package com.example.demo.src.motel.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.time.LocalDate;

@Getter
public class GetMotelRoomRes {

    private Long idx;
    private Long motelIdx;
    private String name;
    private byte order;
    private byte roomCount;
    private byte standardPeople;
    private byte maxPeople;
    private byte daytimeDuration;
    private int daytimeOriginalPrice;
    private byte daytimeDiscount;
    private int daytimeSalePrice;
    private int sleepOverOriginalPrice;
    private byte sleepOverDiscount;
    private int sleepOverSalePrice;
    private LocalDate checkInTime;
    private LocalDate checkOutTime;
    private String daytimeAvailableHour;
    private String description;
    private String status;

    public GetMotelRoomRes(MotelRoom entity) {
        this.idx = entity.getIdx();
        this.motelIdx = entity.getMotelIdx();
        this.name = entity.getName();
        this.order = entity.getOrder();
        this.roomCount = entity.getRoomCount();
        this.standardPeople = entity.getStandardPeople();
        this.maxPeople = entity.getMaxPeople();
        this.daytimeDuration = entity.getDaytimeDuration();
        this.daytimeOriginalPrice = entity.getDaytimeOriginalPrice();
        this.daytimeDiscount = entity.getDaytimeDiscount();
        this.daytimeSalePrice = entity.getDaytimeSalePrice();
        this.sleepOverOriginalPrice = entity.getSleepOverOriginalPrice();
        this.sleepOverDiscount = entity.getSleepOverDiscount();
        this.sleepOverSalePrice = entity.getSleepOverSalePrice();
        this.checkInTime = entity.getCheckInTime();
        this.checkOutTime = entity.getCheckOutTime();
        this.daytimeAvailableHour = entity.getDaytimeAvailableHour();
        this.description = entity.getDescription();
        this.status = entity.getStatus();
    }
}
