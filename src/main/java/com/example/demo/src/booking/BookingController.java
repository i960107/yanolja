package com.example.demo.src.booking;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.booking.model.GetBookingListRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/booking")
public class BookingController {
    private final BookingProvider bookingProvider;
    private final BookingService bookingService;

    @GetMapping("/{userIdx}")
    @ResponseBody
    public BaseResponse<List<GetBookingListRes>> getBookingList(@PathVariable(name ="userIdx") Long userIdx){
        try {
            List<GetBookingListRes> bookingList = bookingProvider.getBookingListById(userIdx);
            return new BaseResponse<>(bookingList);
        }catch(BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }

    }
}
