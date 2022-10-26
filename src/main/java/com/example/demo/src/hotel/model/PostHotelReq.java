package com.example.demo.src.hotel.model;

import com.example.demo.config.Status;
import com.example.demo.src.hotel.model.entity.Hotel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class PostHotelReq {

    @NotBlank
    @Length(max =45)
    private String name;
    @NotNull
    private Long regionIdx;
    @NotNull
    private Float x;
    @NotNull
    private Float y;
    @NotBlank
    private String roadAddressName;
    @NotBlank
    private String addressDetail;
    private String thumbnailImageUrl;
    private String description;
    private String facility;
    @NotBlank
    private String grade;
    private String notice;
    @NotBlank
    private String phone;
    private String event;
    private float rating=0;
    private int reviewCount=0;
    private Boolean verified=false;
    @NotBlank
    private String kakaoPlaceId;
    private Status status = Status.ACTIVATED;

    public Hotel toEntity(){
        return Hotel.builder()
                .name(name)
                .regionIdx(regionIdx)
                .x(x)
                .y(y)
                .kakaoPlaceId(kakaoPlaceId)
                .roadAddressName(roadAddressName)
                .addressDetail(addressDetail)
                .grade(grade)
                .thumbnailImageUrl(thumbnailImageUrl)
                .description(description)
                .facility(facility)
                .notice(notice)
                .phone(phone)
                .event(event)
                .rating(rating)
                .reviewCount(reviewCount)
                .verified(verified)
                .status(status)
                .build();
    }

}
