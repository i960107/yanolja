package com.example.demo.src.review.model;

import com.example.demo.config.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "review_reply")
public class ReviewReply extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private Long reviewIdx;

    @Column
    private String content;

    @Column
    private String status;

    @Builder
    public ReviewReply(Long reviewIdx, String content, String status) {
        this.reviewIdx = reviewIdx;
        this.content = content;
        this.status = status;
    }
}
