package com.example.demo.src.motel.model;

import com.example.demo.config.BaseTimeEntity;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "motel_room")
public class MotelRoom extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idx;

    @Column
    private Long motelIdx;

    @Column
    private String name;

    @Column
    private byte order;

    @Column
    private byte roomCount;

    @Column
    private byte standardPeople;

    @Column
    private byte maxPeople;

    @Column
    private byte daytimeDuration;

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
    private LocalDate checkInTime;

    @Column
    private LocalDate checkOutTime;

    @Column
    private String daytimeAvailableHour;

    @Column
    private String description;

    @Column
    private String status;

    @Builder
    public MotelRoom(Long motelIdx, String name, byte order, byte roomCount, byte standardPeople, byte maxPeople,
                     byte daytimeDuration, int daytimeOriginalPrice, byte daytimeDiscount, int daytimeSalePrice,
                     int sleepOverOriginalPrice, byte sleepOverDiscount, int sleepOverSalePrice, LocalDate checkInTime,
                     LocalDate checkOutTime, String daytimeAvailableHour, String description, String status) {
        this.motelIdx = motelIdx;
        this.name = name;
        this.order = order;
        this.roomCount = roomCount;
        this.standardPeople = standardPeople;
        this.maxPeople = maxPeople;
        this.daytimeDuration = daytimeDuration;
        this.daytimeOriginalPrice = daytimeOriginalPrice;
        this.daytimeDiscount = daytimeDiscount;
        this.daytimeSalePrice = daytimeSalePrice;
        this.sleepOverOriginalPrice = sleepOverOriginalPrice;
        this.sleepOverDiscount = sleepOverDiscount;
        this.sleepOverSalePrice = sleepOverSalePrice;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.daytimeAvailableHour = daytimeAvailableHour;
        this.description = description;
        this.status = status;
    }
}
