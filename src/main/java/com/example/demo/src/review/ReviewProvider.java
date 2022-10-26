package com.example.demo.src.review;

import com.example.demo.config.BaseException;
import com.example.demo.config.Status;
import com.example.demo.src.hotel.model.entity.HotelRepository;
import com.example.demo.src.motel.model.MotelRepository;
import com.example.demo.src.review.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo.config.BaseResponseStatus.ACCOMMODATION_IDX_ERROR;

@RequiredArgsConstructor
@Service
public class ReviewProvider {

    private final ReviewRepository reviewRepository;
    private final ReviewReplyRepository reviewReplyRepository;
    private final HotelRepository hotelRepository;
    private final MotelRepository motelRepository;
    private final EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<GetReviewRes> retrieveHotelReviewList(Long hotelIdx) throws BaseException {

        hotelRepository.findByIdxAndStatus(hotelIdx, Status.ACTIVATED)
                .orElseThrow(() -> new BaseException(ACCOMMODATION_IDX_ERROR));

        List<GetReviewRes> reviewResponseDto = new ArrayList<GetReviewRes>();

        List<Review> hotelReview = reviewRepository.findByHotelIdx(hotelIdx);

        for (Review review : hotelReview) {

            ReviewReply reviewReply = reviewReplyRepository.findByReviewIdxAndStatus(review.getIdx(), "ACTIVATED");

            if (reviewReply == null) {
                reviewResponseDto.add(new GetReviewRes(review));
            } else {
                reviewResponseDto.add(new GetReviewRes(review, reviewReply));
            }

        }

        return reviewResponseDto;

    }

    @Transactional(readOnly = true)
    public List<GetReviewRes> retrieveMotelReviewList(Long motelIdx) throws BaseException {

        motelRepository.findByIdxAndStatus(motelIdx, "ACTIVATED")
                .orElseThrow(() -> new BaseException(ACCOMMODATION_IDX_ERROR));

        List<GetReviewRes> reviewResponseDto = new ArrayList<GetReviewRes>();

        List<Review> motelReview = reviewRepository.findByMotelIdx(motelIdx);

        for (Review review : motelReview) {

            ReviewReply reviewReply = reviewReplyRepository.findByReviewIdxAndStatus(review.getIdx(), "ACTIVATED");

            if (reviewReply == null) {
                reviewResponseDto.add(new GetReviewRes(review));
            } else {
                reviewResponseDto.add(new GetReviewRes(review, reviewReply));
            }

        }

        return reviewResponseDto;
    }

    @Transactional(readOnly = true)
    public GetRatingRes retrieveRatingInfo(String accommodationType, Long accommodationIdx) throws BaseException {

        if (accommodationType.equals("hotel")) {

            hotelRepository.findByIdxAndStatus(accommodationIdx, Status.ACTIVATED)
                    .orElseThrow(() -> new BaseException(ACCOMMODATION_IDX_ERROR));

            Query query = entityManager.createNamedQuery("findRating")
                    .setParameter("accommodationType", "호텔")
                    .setParameter("accommodationIdx", accommodationIdx);

            GetRatingRes result = (GetRatingRes) query.getSingleResult();

            return result;

        } else if (accommodationType.equals("motel")) {

            motelRepository.findByIdxAndStatus(accommodationIdx, "ACTIVATED")
                    .orElseThrow(() -> new BaseException(ACCOMMODATION_IDX_ERROR));

            Query query = entityManager.createNamedQuery("findRating")
                    .setParameter("accommodationType", "모텔")
                    .setParameter("accommodationIdx", accommodationIdx);

            GetRatingRes result = (GetRatingRes) query.getSingleResult();

            return result;

        } else {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        }

    }
}
