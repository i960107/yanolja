package com.example.demo.src.recommendation;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.recommendation.model.GetRecommendationRes;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/recommendation")
public class RecommendationController {

    private final RecommendationProvider recommendationProvider;
    private final RecommendationService recommendationService;

    @ResponseBody
    @GetMapping("")
    public BaseResponse<List<GetRecommendationRes>> retrieveRecommendationList(
            @RequestParam("accommodationType") String accommodationType,
            @RequestParam("accommodationIdx") Long accommodationIdx
    ){
        try{

            return new BaseResponse<List<GetRecommendationRes>>(
                    recommendationProvider.retrieveRecommendationList(accommodationType,accommodationIdx));

        }catch(BaseException exception) {

            return new BaseResponse<>(exception.getStatus());

        }
    }
}
