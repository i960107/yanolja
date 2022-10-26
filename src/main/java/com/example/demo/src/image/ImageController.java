package com.example.demo.src.image;

import com.example.demo.config.Auth;
import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.hotel.model.PostHotelImageRes;
import com.example.demo.src.users.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageProvider imageProvider;
    private final ImageService imageService;

    @GetMapping("/api/hotel/{hotelIdx}/image")
    @ResponseBody
    public void  retrieveHotelImage(
            @PathVariable("hotelIdx") Long hotelIdx
    ) {

    }

}
