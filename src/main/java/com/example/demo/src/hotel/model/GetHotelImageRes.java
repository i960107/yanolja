package com.example.demo.src.hotel.model;


import com.example.demo.config.Status;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetHotelImageRes {
    private Long idx;
    private String imageUrl;
    private byte order;
    private Status status;

    @Builder
    public GetHotelImageRes(Long idx, String imageUrl, byte order, Status status) {
        this.idx = idx;
        this.imageUrl = imageUrl;
        this.order = order;
        this.status = status;
    }
}
