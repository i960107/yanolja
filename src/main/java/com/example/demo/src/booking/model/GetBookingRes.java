package com.example.demo.src.booking.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class GetBookingRes {
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
}
