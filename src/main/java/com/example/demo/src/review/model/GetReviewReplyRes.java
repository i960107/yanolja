package com.example.demo.src.review.model;

import lombok.Getter;

@Getter
public class GetReviewReplyRes {

    private Long idx;
    private Long reviewIdx;
    private String content;
    private String status;

    public GetReviewReplyRes(ReviewReply entity) {
        this.idx = entity.getIdx();
        this.reviewIdx = entity.getReviewIdx();
        this.content = entity.getContent();
        this.status = entity.getStatus();
    }
}
