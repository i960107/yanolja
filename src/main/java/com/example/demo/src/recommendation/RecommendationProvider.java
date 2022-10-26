package com.example.demo.src.recommendation;

import com.example.demo.config.BaseException;
import com.example.demo.config.Status;
import com.example.demo.src.hotel.model.entity.Hotel;
import com.example.demo.src.hotel.model.entity.HotelRepository;
import com.example.demo.src.motel.model.Motel;
import com.example.demo.src.motel.model.MotelRepository;
import com.example.demo.src.recommendation.model.GetRecommendationRes;
import com.example.demo.src.recommendation.model.Recommendation;
import com.example.demo.src.recommendation.model.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.config.BaseResponseStatus.ACCOMMODATION_IDX_ERROR;
import static com.example.demo.config.BaseResponseStatus.ACCOMMODATION_TYPE_ERROR;

@RequiredArgsConstructor
@Service
public class RecommendationProvider {

    private final RecommendationRepository recommendationRepository;
    private final HotelRepository hotelRepository;
    private final MotelRepository motelRepository;

    @Transactional(readOnly = true)
    public List<GetRecommendationRes> retrieveRecommendationList(
            String accommodationType,
            Long accommodationIdx
    ) throws BaseException {

        if (!accommodationType.equals("호텔") && !accommodationType.equals("모텔")) {
            throw new BaseException(ACCOMMODATION_TYPE_ERROR);
        }

        if(accommodationType.equals("호텔")) hotelRepository.findByIdxAndStatus(accommodationIdx, Status.ACTIVATED)
                                                .orElseThrow(()->new BaseException(ACCOMMODATION_IDX_ERROR));

        if(accommodationType.equals("모텔")) motelRepository.findByIdxAndStatus(accommodationIdx,"ACTIVATED")
                                                .orElseThrow(()->new BaseException(ACCOMMODATION_IDX_ERROR));

        List<Recommendation> list = recommendationRepository.findByAccommodationTypeAndAccommodationIdxAndStatus(
                accommodationType, accommodationIdx, "ACTIVATED");

        List<GetRecommendationRes> recommendList = new ArrayList<GetRecommendationRes>();

        for (Recommendation rec : list) {

            if (rec.getAccommodationType().equals("호텔")) {
                Hotel hotel = hotelRepository.findByIdxAndStatus(
                        rec.getRecommendationIdx(),
                        Status.ACTIVATED).orElse(null);

                if (hotel != null) {

                    recommendList.add(new GetRecommendationRes(rec, hotel));

                }

            } else if (rec.getAccommodationType().equals("모텔")) {
                Motel motel = motelRepository.findByIdxAndStatus(
                        rec.getRecommendationIdx(),
                        "ACTIVATED").orElse(null);

                if (motel != null) {

                    recommendList.add(new GetRecommendationRes(rec, motel));

                }

            }
        }
        return recommendList;
    }
}
