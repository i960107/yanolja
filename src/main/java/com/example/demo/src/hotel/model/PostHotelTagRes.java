package com.example.demo.src.hotel.model;

import com.example.demo.src.tag.model.GetTagRes;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class PostHotelTagRes {
    private Long hotelIdx;
    private List<GetTagRes> tags;
}
