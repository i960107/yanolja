package com.example.demo.src.bookmark.model;

import com.example.demo.src.hotel.model.GetHotelRes;
import com.example.demo.src.hotel.model.entity.Hotel;
import com.example.demo.src.motel.model.GetMotelRes;
import com.example.demo.src.motel.model.Motel;
import lombok.Getter;

@Getter
public class BookmarkedAccommodation {
    private GetHotelRes hotel;
    private GetMotelRes motel;
    public BookmarkedAccommodation(Hotel hotel){
        this.hotel = new GetHotelRes(hotel);
    }
    public BookmarkedAccommodation(Motel motel){
        this.motel = new GetMotelRes(motel);
    }
}
