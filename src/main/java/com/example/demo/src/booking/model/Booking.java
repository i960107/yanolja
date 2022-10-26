package com.example.demo.src.booking.model;

import com.example.demo.config.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name="booking")
public class Booking extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private Long userIdx;

    @Column
    private String accommodationType;

    @Column
    private Long roomIdx;

    @Column
    private String bookType;

    @Column
    private LocalDateTime checkIn;

    @Column
    private LocalDateTime checkOut;

    @Column
    private String bookHour;

    @Column
    private String name;

    @Column
    private String phone;

    @Column
    private String parking;

    @Column
    private String status;

    @Builder
    public Booking(Long userIdx, String accommodationType, Long roomIdx, String bookType, LocalDateTime checkIn, LocalDateTime checkOut, String bookHour, String name, String phone, String parking, String status) {
        this.userIdx = userIdx;
        this.accommodationType = accommodationType;
        this.roomIdx = roomIdx;
        this.bookType = bookType;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.bookHour = bookHour;
        this.name = name;
        this.phone = phone;
        this.parking = parking;
        this.status = status;
    }
}
