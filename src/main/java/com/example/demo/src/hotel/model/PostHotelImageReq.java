package com.example.demo.src.hotel.model;

import com.example.demo.config.Status;
import com.example.demo.src.image.model.entity.HotelImage;
import com.example.demo.src.image.model.entity.Image;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter
public class PostHotelImageReq {
    @NotNull
    ArrayList<Map<String, Object>> images;

    public ArrayList<HotelImage> toHotelImageEntity() {
        ArrayList<HotelImage> hotelImageArrayList = new ArrayList<>();
        for (Map<String, Object> image : images) {
            String imageUrl = image.get("imageUrl").toString();
            byte position = Byte.parseByte( image.get("position").toString());
            HotelImage hotelImage = HotelImage.builder().imageUrl(imageUrl).order(position).status(Status.ACTIVATED).build();
            hotelImageArrayList.add(hotelImage);
        }
        return hotelImageArrayList;
    }
}

