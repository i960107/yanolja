package com.example.demo.src.review.model;

import lombok.Getter;

@Getter
public class GetReviewRes {

    private Long idx;
    private String accommodationType;
    private Long accommodationIdx;
    private Long roomIdx;
    private Long bookingIdx;
    private Long userIdx;
    private byte kindness;
    private byte cleanliness;
    private byte convenience;
    private byte locationSatisfaction;
    private String imageUrl1;
    private String imageUrl2;
    private String imageUrl3;
    private String content;
    private float rating;
    private String status;
    private GetReviewReplyRes reviewReply;

    public GetReviewRes(Review review, ReviewReply reviewReply) {
        this.idx = review.getIdx();
        this.accommodationType = review.getAccommodationType();
        this.accommodationIdx = review.getAccommodationIdx();
        this.roomIdx = review.getRoomIdx();
        this.bookingIdx = review.getBookingIdx();
        this.userIdx = review.getUserIdx();
        this.kindness = review.getKindness();
        this.cleanliness = review.getCleanliness();
        this.convenience = review.getConvenience();
        this.locationSatisfaction = review.getLocationSatisfaction();
        this.content = review.getContent();
        this.rating = review.getRating();
        this.status = review.getStatus();
        this.reviewReply = new GetReviewReplyRes(reviewReply);
    }

    public GetReviewRes(Review review){
        this.idx = review.getIdx();
        this.accommodationType = review.getAccommodationType();
        this.accommodationIdx = review.getAccommodationIdx();
        this.roomIdx = review.getRoomIdx();
        this.bookingIdx = review.getBookingIdx();
        this.userIdx = review.getUserIdx();
        this.kindness = review.getKindness();
        this.cleanliness = review.getCleanliness();
        this.convenience = review.getConvenience();
        this.locationSatisfaction = review.getLocationSatisfaction();
        this.content = review.getContent();
        this.rating = review.getRating();
        this.status = review.getStatus();
    }
}
