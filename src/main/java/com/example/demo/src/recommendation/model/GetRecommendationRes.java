package com.example.demo.src.recommendation.model;

import com.example.demo.src.hotel.model.GetHotelRes;
import com.example.demo.src.hotel.model.entity.Hotel;
import com.example.demo.src.motel.model.GetMotelRes;
import com.example.demo.src.motel.model.Motel;
import lombok.Getter;

@Getter
public class GetRecommendationRes {
    private Long idx;
    private String status;
    private GetHotelRes getHotelRes;
    private GetMotelRes getMotelRes;

    public GetRecommendationRes(Recommendation recommend, Hotel hotel){
       this.idx = recommend.getIdx();
       this.status = recommend.getStatus();
       this.getHotelRes = new GetHotelRes(hotel);
    }
    public GetRecommendationRes(Recommendation recommend, Motel motel){
       this.idx = recommend.getIdx();
       this.status = recommend.getStatus();
       this.getMotelRes = new GetMotelRes(motel);
    }
}
