package com.example.demo.src.hotel;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponseStatus;
import com.example.demo.config.Status;
import com.example.demo.src.hotel.model.*;
import com.example.demo.src.hotel.model.entity.Hotel;
import com.example.demo.src.hotel.model.entity.HotelRepository;
import com.example.demo.src.image.model.entity.HotelImage;
import com.example.demo.src.image.model.entity.HotelImageRepository;
import com.example.demo.src.tag.model.GetTagRes;
import com.example.demo.src.tag.model.Tag;
import com.example.demo.src.tag.model.TagRepository;
import com.example.demo.src.users.businessUser.model.BusinessUser;
import com.example.demo.src.users.businessUser.model.BusinessUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@Service
@Transactional(readOnly = false)
public class HotelService {
    private final HotelRepository hotelRepository;
    private final HotelImageRepository hotelImageRepository;
    private final BusinessUserRepository businessUserRepository;
    private final TagRepository tagRepository;

    public PostHotelRes createHotel(PostHotelReq requestDto, Long userIdx) throws BaseException {
        Hotel hotel = null;
        if (hotelRepository.findByKakaoPlaceId(requestDto.getKakaoPlaceId()).isPresent())
            throw new BaseException(BaseResponseStatus.POST_ACCOMMODATION_EXISTS_KAKAOPLACEID);
        try {
            hotel = hotelRepository.save(requestDto.toEntity());
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }

        BusinessUser user = businessUserRepository.findByIdxAndStatus(userIdx, Status.ACTIVATED)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.USERS_EMPTY_USER_IDX));
        user.updateAccommodation("호텔", hotel.getIdx());
        try {
            businessUserRepository.save(user);
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
        return new PostHotelRes(hotel.getIdx());
    }

    public PostHotelImageRes createHotelImage(Long userIdx, Long hotelIdx, PostHotelImageReq requestDto) throws BaseException {
        businessUserRepository.findByIdxAndAccommodationTypeAndAccommodationIdxAndStatus(userIdx, "호텔", hotelIdx, Status.ACTIVATED).orElseThrow(() -> new BaseException(BaseResponseStatus.POST_ACCOMMODATION_IMAGE_INVALID_BUSINESS_USER));
        Hotel hotel = hotelRepository.findByIdxAndStatus(hotelIdx, Status.ACTIVATED).orElseThrow(() -> new BaseException(BaseResponseStatus.ACCOMMODATION_IDX_ERROR));

        ArrayList<HotelImage> imageList = requestDto.toHotelImageEntity();
        ArrayList<HotelImage> images = new ArrayList<>();
        for (HotelImage image : imageList) {
            image.setHotel(hotel);
            images.add(hotelImageRepository.save(image));
            hotel.getHotelImages().add(image);
        }
        return new PostHotelImageRes(images);
    }

    public DeleteHotelRes deleteHotel(Long userIdx, Long hotelIdx) throws BaseException {
        businessUserRepository.findByIdxAndAccommodationTypeAndAccommodationIdxAndStatus(userIdx, "호텔", hotelIdx, Status.ACTIVATED).orElseThrow(() -> new BaseException(BaseResponseStatus.POST_ACCOMMODATION_IMAGE_INVALID_BUSINESS_USER));
        Hotel hotel = hotelRepository.findByIdxAndStatus(hotelIdx, Status.ACTIVATED).orElseThrow(() -> new BaseException(BaseResponseStatus.ACCOMMODATION_IDX_ERROR));
        hotelRepository.deleteById(hotelIdx);
        return new DeleteHotelRes(hotelIdx);
    }

    public PostHotelTagRes createHotelTag(PostHotelTagReq requestDto, Long hotelIdx, Long userIdx) throws BaseException {
        businessUserRepository.findByIdxAndAccommodationTypeAndAccommodationIdxAndStatus(userIdx, "호텔", hotelIdx, Status.ACTIVATED).orElseThrow(() -> new BaseException(BaseResponseStatus.POST_ACCOMMODATION_IMAGE_INVALID_BUSINESS_USER));
        Hotel hotel = hotelRepository.findByIdxAndStatus(hotelIdx, Status.ACTIVATED).orElseThrow(() -> new BaseException(BaseResponseStatus.ACCOMMODATION_IDX_ERROR));
        for (Long tagIdx : requestDto.getTags()) {
            Tag tag = tagRepository.findByIdxAndStatus(tagIdx, Status.ACTIVATED).orElseThrow(() -> new BaseException(BaseResponseStatus.TAGS_EMPTY_IDX));
            hotel.getTags().add(tag);
        }
        List<GetTagRes> mapTag = new ArrayList<GetTagRes>();
        hotel = hotelRepository.save(hotel);
        for(Tag tag: hotel.getTags()){
            mapTag.add(new GetTagRes(tag));
        }
        return new PostHotelTagRes(hotelIdx,mapTag);
    }
}

