package com.example.demo.src.hotel.model.entity;

import com.example.demo.config.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name="hotel_room")
public class HotelRoom extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idx;

    @Column
    private Long hotelIdx;

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
    private int originalPrice;

    @Column
    private byte discount;

    @Column
    private int salePrice;

    @Column
    private LocalTime checkInTime;

    @Column
    private LocalTime checkOutTime;

    @Column
    private String description;

    @Column
    private String thumbnailImageUrl;

    @Column
    private String status;

    @Builder
    public HotelRoom(Long hotelIdx, String name, byte order, byte roomCount, byte standardPeople, byte maxPeople, int originalPrice, byte discount, int salePrice, LocalTime checkInTime, LocalTime checkOutTime, String description, String thumbnailImageUrl, String status) {
        this.hotelIdx = hotelIdx;
        this.name = name;
        this.order = order;
        this.roomCount = roomCount;
        this.standardPeople = standardPeople;
        this.maxPeople = maxPeople;
        this.originalPrice = originalPrice;
        this.discount = discount;
        this.salePrice = salePrice;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.description = description;
        this.thumbnailImageUrl = thumbnailImageUrl;
        this.status = status;
    }
}
