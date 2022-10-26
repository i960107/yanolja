package com.example.demo.src.hotel.model;

import com.example.demo.src.image.model.entity.HotelImage;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class PostHotelImageRes {
    private ArrayList<GetHotelImageRes> images=  new ArrayList();

    public PostHotelImageRes(ArrayList<HotelImage> images) {
        for (HotelImage image : images) {
            GetHotelImageRes getHotelImageRes =
                    GetHotelImageRes.builder().imageUrl(image.getImageUrl())
                            .order(image.getPosition())
                            .status(image.getStatus())
                            .idx(image.getIdx())
                            .build();

            this.images.add(getHotelImageRes);
        }
    }
}