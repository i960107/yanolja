package com.example.demo.src.hotel.model.entity;

import com.example.demo.config.BaseTimeEntity;
import com.example.demo.config.Status;
import com.example.demo.src.image.model.entity.HotelImage;
import com.example.demo.src.tag.model.AccommodationTag;
import com.example.demo.src.tag.model.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE `hotel` SET status = 'DELETED' WHERE idx = ?")
@Table(name = "hotel")
public class Hotel extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String name;

    @Column
    private Long regionIdx;

    @Column
    private Float x;

    @Column
    private Float y;

    @Column
    private String kakaoPlaceId;

    @Column
    private String location;

    @Column
    private String roadAddressName;

    @Column
    private String addressDetail;

    @Column
    private String grade;

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
    private Boolean verified;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY)
    @Where(clause = "status= 'ACTIVATED'")
    private List<HotelImage> hotelImages = new ArrayList<>();

    @OneToMany(mappedBy = "hotelIdx")
    @Where(clause = "status = 'ACTIVATED and accommodationType = '호텔'")
    private List<AccommodationTag> tags = new ArrayList<>();

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Builder
    public Hotel(Long idx,
                 String name,
                 Long regionIdx,
                 Float x,
                 Float y,
                 String kakaoPlaceId,
                 String location,
                 String roadAddressName,
                 String addressDetail,
                 String grade,
                 String thumbnailImageUrl,
                 String description,
                 String facility,
                 String notice,
                 String phone,
                 String event,
                 float rating,
                 int reviewCount,
                 byte maxPeople,
                 int originalPrice,
                 byte discount,
                 int salePrice,
                 LocalTime checkInTime,
                 Boolean verified,
                 Status status) {
        this.idx = idx;
        this.name = name;
        this.regionIdx = regionIdx;
        this.x = x;
        this.y = y;
        this.kakaoPlaceId = kakaoPlaceId;
        this.location = location;
        this.roadAddressName = roadAddressName;
        this.addressDetail = addressDetail;
        this.grade = grade;
        this.thumbnailImageUrl = thumbnailImageUrl;
        this.description = description;
        this.facility = facility;
        this.notice = notice;
        this.phone = phone;
        this.event = event;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.maxPeople = maxPeople;
        this.originalPrice = originalPrice;
        this.discount = discount;
        this.salePrice = salePrice;
        this.checkInTime = checkInTime;
        this.verified = verified;
        this.status = status;
    }
}


