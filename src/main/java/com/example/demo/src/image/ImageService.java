package com.example.demo.src.image;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponseStatus;
import com.example.demo.src.hotel.model.PostHotelImageReq;
import com.example.demo.src.hotel.model.PostHotelImageRes;
import com.example.demo.src.hotel.model.entity.Hotel;
import com.example.demo.src.hotel.model.entity.HotelRepository;
import com.example.demo.src.image.model.entity.HotelImage;
import com.example.demo.src.image.model.entity.HotelImageRepository;
import com.example.demo.src.image.model.entity.HotelRoomImageRepository;
import com.example.demo.src.image.model.entity.ImageRepository;
import com.example.demo.src.users.businessUser.model.BusinessUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = false, rollbackFor = Exception.class)
public class ImageService {
    private final ImageRepository imageRepository;
    private final HotelImageRepository hotelImageRepository;
    private final HotelRoomImageRepository hotelRoomImageRepository;
    private final BusinessUserRepository businessUserRepository;
    private final HotelRepository hotelRepository;

}
