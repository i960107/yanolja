package com.example.demo.src.image;

import com.example.demo.config.BaseException;
import com.example.demo.src.image.model.entity.HotelImageRepository;
import com.example.demo.src.image.model.entity.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ImageProvider {

    private final ImageRepository imageRepository;
    private final HotelImageRepository hotelImageRepository;

    public void retrieveHotelImage(Long hotelIdx) throws BaseException {

    }
}
