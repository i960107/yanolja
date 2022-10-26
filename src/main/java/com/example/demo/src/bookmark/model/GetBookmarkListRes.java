package com.example.demo.src.bookmark.model;

import com.example.demo.src.hotel.model.entity.Hotel;
import com.example.demo.src.motel.model.Motel;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class GetBookmarkListRes {
    private Long idx;
    private Long userIdx;
    private String accommodationType;
    private BookmarkedAccommodation bookmarkedAccommodation;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public GetBookmarkListRes(Bookmark entity, Hotel hotel){
        this.idx = entity.getIdx();
        this.userIdx = entity.getUserIdx();
        this.accommodationType = entity.getAccommodationType();
        this.bookmarkedAccommodation = new BookmarkedAccommodation(hotel);
        this.status = entity.getStatus();
        this. createdAt = entity.getCreatedAt();
        this. updatedAt = entity.getUpdatedAt();
    }
    public GetBookmarkListRes(Bookmark entity, Motel motel){
        this.idx = entity.getIdx();
        this.userIdx = entity.getUserIdx();
        this.accommodationType = entity.getAccommodationType();
        this.bookmarkedAccommodation = new BookmarkedAccommodation(motel);
        this.status = entity.getStatus();
        this. createdAt = entity.getCreatedAt();
        this. updatedAt = entity.getUpdatedAt();
    }
}
