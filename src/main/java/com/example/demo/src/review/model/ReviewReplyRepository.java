package com.example.demo.src.review.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewReplyRepository extends JpaRepository<ReviewReply,Long> {

    ReviewReply findByReviewIdxAndStatus(Long reviewIdx, String status);
}
