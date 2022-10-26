package com.example.demo.src.hotel.model;

import com.example.demo.src.hotel.model.entity.HotelRoom;
import lombok.Getter;

import java.time.LocalTime;

@Getter
public class GetHotelRoomRes {
    private Long idx;
    private Long hotelIdx;
    private String name;
    private byte order;
    private byte roomCount;
    private byte standardPeople;
    private byte maxPeople;
    private int originalPrice;
    private byte discount;
    private int salePrice;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;
    private String description;
    private String thumbnailImageUrl;
    private String status;

    public GetHotelRoomRes(HotelRoom entity) {
        this.idx = entity.getIdx();
        this.hotelIdx = entity.getHotelIdx();
        this.name = entity.getName();
        this.order = entity.getOrder();
        this.roomCount = entity.getRoomCount();
        this.standardPeople = entity.getStandardPeople();
        this.maxPeople = entity.getMaxPeople();
        this.originalPrice = entity.getOriginalPrice();
        this.discount = entity.getDiscount();
        this.salePrice = entity.getSalePrice();
        this.checkInTime = entity.getCheckInTime();
        this.checkOutTime = entity.getCheckOutTime();
        this.description = entity.getDescription();
        this.thumbnailImageUrl = entity.getThumbnailImageUrl();
        this.status = entity.getStatus();

    }
}
