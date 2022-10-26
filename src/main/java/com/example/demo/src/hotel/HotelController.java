package com.example.demo.src.hotel;

import com.example.demo.config.Auth;
import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.hotel.model.*;
import com.example.demo.src.users.Role;
import com.example.demo.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    final HotelService hotelService;
    final HotelProvider hotelProvider;
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    final JwtService jwtService;

    @ResponseBody
    @PostMapping("")
    @Auth(role = Role.BUSINESS_USER)
    public BaseResponse<PostHotelRes> createHotel(@RequestAttribute("businessUserIdx") Long userIdx, @Valid @RequestBody PostHotelReq requestDto) throws BaseException {

        PostHotelRes responseDto = hotelService.createHotel(requestDto, userIdx);
        return new BaseResponse<PostHotelRes>(responseDto);
    }
    @ResponseBody
    @PostMapping("/{hotelIdx}/tag")
    @Auth(role = Role.BUSINESS_USER)
    public BaseResponse<PostHotelTagRes> createHotelTag(@RequestAttribute("businessUserIdx") Long userIdx, @PathVariable("hotelIdx") Long hotelIdx, @Valid @RequestBody PostHotelTagReq requestDto) throws BaseException {
        PostHotelTagRes responseDto = hotelService.createHotelTag(requestDto, hotelIdx, userIdx);
        return new BaseResponse<PostHotelTagRes>(responseDto);
    }

    @ResponseBody
    @GetMapping("")
    public BaseResponse<List<GetHotelListRes>> retrieveHotelList(@RequestParam(name = "tagIdx", required = true) long tagIdx,
                                                                 @RequestParam(name = "people", required = true) byte people,
                                                                 @RequestParam(name = "checkIn", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkIn,
                                                                 @RequestParam(name = "checkOut", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkOut,
                                                                 @RequestParam(name = "regionIdx", required = true) long regionIdx,
                                                                 @RequestParam(name = "sort", required = true) String sort
    ) {
        try {
            List<GetHotelListRes> hotelList = hotelProvider.retrieveHotelList(tagIdx, people, checkIn, checkOut, regionIdx, sort);
            return new BaseResponse<List<GetHotelListRes>>(hotelList);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/{hotelIdx}")
    public BaseResponse<GetHotelRes> retrieveHotel(@PathVariable("hotelIdx") Long hotelIdx) {
        try {
            return new BaseResponse<GetHotelRes>(hotelProvider.retrieveHotel(hotelIdx));
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("{hotelIdx}/room")
    public BaseResponse<List<GetHotelRoomRes>> retrieveHotelRoomList(@PathVariable("hotelIdx") Long hotelIdx) {
        try {
            return new BaseResponse<List<GetHotelRoomRes>>(hotelProvider.retrieveHotelRoomList(hotelIdx));
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }


    @ResponseBody
    @GetMapping("{hotelIdx}/room/{roomIdx}")
    public BaseResponse<GetHotelRoomRes> retrieveHotelRoom(@PathVariable("hotelIdx") Long hotelIdx, @PathVariable("roomIdx") Long roomIdx) {
        try {
            return new BaseResponse<>(hotelProvider.retrieveHotelRoom(hotelIdx, roomIdx));
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @PostMapping("{hotelIdx}/image")
    @Auth(role = Role.BUSINESS_USER)
    public  BaseResponse<PostHotelImageRes> createHotelImage(@RequestAttribute("businessUserIdx") Long userIdx, @PathVariable("hotelIdx") Long hotelIdx, @RequestBody com.example.demo.src.hotel.model.PostHotelImageReq requestDto) throws BaseException {
        PostHotelImageRes responseDto = hotelService.createHotelImage(userIdx, hotelIdx, requestDto);
        return new BaseResponse<PostHotelImageRes>(responseDto);
    }
//    @ResponseBody @GetMapping("{hotelIdx}/image")
//    public BaseResponse<GetHotelImageRes> retrieveHotelImageList(@PathVariable("hotelIdx")Long hotelIdx)throws BaseException{
//        GetPostImageRes responseDto = hotelProvider.retrieveHotelImageList(hotelIdx);
//
//    }
    @ResponseBody
    @DeleteMapping("{hotelIdx}")
    @Auth(role= Role.BUSINESS_USER)
    public BaseResponse<DeleteHotelRes> deleteHotel(@RequestAttribute("businessUserIdx")Long userIdx, @PathVariable("hotelIdx") Long hotelIdx)throws BaseException{
        DeleteHotelRes responseDto = hotelService.deleteHotel(userIdx,hotelIdx);
        return new BaseResponse<>(responseDto);

    }
}
