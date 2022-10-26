package com.example.demo.src.hotel.model;

import com.example.demo.config.Status;
import com.example.demo.src.hotel.model.entity.Hotel;
import com.example.demo.src.image.model.entity.HotelImage;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class GetHotelListRes {
    private Long idx;
    private String name;
    private Long regionIdx;
    private Float x;
    private Float y;
    private String kakaoPlaceId;
    private String location;
    private String roadAddressName;
    private String addressDetail;
    private String grade;
    private String thumbnailImageUrl;
    private String description;
    private String facility;
    private String notice;
    private String phone;
    private String event;
    private float rating;
    private int reviewCount;
    private int originalPrice;
    private byte discount;
    private int salePrice;
    private LocalTime checkInTime;
    private byte maxPeople;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Status status;
    private List<GetHotelImageRes> hotelImage;

    public GetHotelListRes(Hotel hotel) {

        List<GetHotelImageRes> hotelImage = new ArrayList<>();
        for (HotelImage image : hotel.getHotelImages()) {
            GetHotelImageRes getHotelImageRes =GetHotelImageRes.builder().imageUrl(image.getImageUrl()).idx(image.getIdx()).order(image.getPosition()).status(image.getStatus()).build();
            hotelImage.add(getHotelImageRes);
        }
        this.hotelImage = hotelImage;
        this.idx = hotel.getIdx();
        this.name = hotel.getName();
        this.regionIdx = hotel.getRegionIdx();
        this.x = hotel.getX();
        this.y = hotel.getY();
        this.kakaoPlaceId = hotel.getKakaoPlaceId();
        this.location = hotel.getLocation();
        this.roadAddressName = hotel.getRoadAddressName();
        this.addressDetail = hotel.getAddressDetail();
        this.grade = hotel.getGrade();
        this.thumbnailImageUrl = hotel.getThumbnailImageUrl();
        this.description = hotel.getDescription();
        this.facility = hotel.getFacility();
        this.notice = hotel.getNotice();
        this.phone = hotel.getPhone();
        this.event = hotel.getEvent();
        this.rating = hotel.getRating();
        this.reviewCount = hotel.getReviewCount();
        this.originalPrice = hotel.getOriginalPrice();
        this.discount = hotel.getDiscount();
        this.salePrice = hotel.getSalePrice();
        this.checkInTime = hotel.getCheckInTime();
        this.maxPeople = hotel.getMaxPeople();
        this.createdAt = hotel.getCreatedAt();
        this.updatedAt = hotel.getUpdatedAt();
        this.status = hotel.getStatus();
    }
}