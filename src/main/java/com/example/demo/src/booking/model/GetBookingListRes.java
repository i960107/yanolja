package com.example.demo.src.booking.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class GetBookingListRes {
    private Long idx;
    private Long userIdx;
    private String accommodationType;
    private String bookType;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private String bookHour;
    private String name;
    private String phone;
    private String parking;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String status;

    public GetBookingListRes(Booking entity){
        this.idx= entity.getIdx();
        this.userIdx = entity.getUserIdx();
        this.accommodationType = entity.getAccommodationType();
        this.bookType = entity.getBookType();
        this.checkIn= entity.getCheckIn();
        this.checkOut= entity.getCheckOut();
        this.bookHour = entity.getBookHour();
        this.name = entity. getName();
        this.phone=entity.getPhone();
        this.parking = entity.getParking();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity. getUpdatedAt();
        this.status = entity. getStatus();
    }


}
