package com.example.demo.src.hotel.model;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
public class PostHotelTagReq {
    @NotNull
    List<Long> tags;
}
