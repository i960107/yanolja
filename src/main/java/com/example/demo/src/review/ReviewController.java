package com.example.demo.src.review;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.review.model.GetRatingRes;
import com.example.demo.src.review.model.GetReviewRes;
import javassist.tools.web.BadHttpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReviewController {

    private final ReviewProvider reviewProvider;
    private final ReviewService reviewService;

    @ResponseBody
    @GetMapping("api/hotel/{hotelIdx}/review")
    public BaseResponse<List<GetReviewRes>> retrieveHotelReviewList(@PathVariable("hotelIdx") Long hotelIdx){

       try{

           return new BaseResponse(reviewProvider.retrieveHotelReviewList(hotelIdx));

       }catch(BaseException exception){

           return new BaseResponse<>(exception.getStatus());

       }

    }

    @ResponseBody
    @GetMapping("api/motel/{motelIdx}/review")
    public BaseResponse<List<GetReviewRes>> retrieveMotelReviewList(@PathVariable("motelIdx") Long motelIdx){

       try{

           return new BaseResponse(reviewProvider.retrieveMotelReviewList(motelIdx));

       }catch(BaseException exception){

           return new BaseResponse<>(exception.getStatus());

       }

    }

    @ResponseBody
    @GetMapping("/api/{accommodationType}/{accommodationIdx}/review/rating")
    public BaseResponse<GetRatingRes> retrieveRatingInfo(
            @PathVariable("accommodationType") String accommodationType,
            @PathVariable("accommodationIdx") Long accommodationIdx
    ){

        try{

            return new BaseResponse<GetRatingRes>(reviewProvider.retrieveRatingInfo(accommodationType, accommodationIdx));

        }catch(BaseException exception){

            return new BaseResponse<>(exception.getStatus());

        }
    }

}
