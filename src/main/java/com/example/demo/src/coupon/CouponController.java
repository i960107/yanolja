package com.example.demo.src.coupon;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.coupon.model.GetCouponRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/coupon")
public class CouponController {
    private final CouponProvider couponProvider;
    private final CouponService couponService;

    @ResponseBody
    @GetMapping("/{userIdx}")
    public BaseResponse<List<GetCouponRes>> retrieveUserCoupon(@PathVariable("userIdx") Long userIdx) {
        try {
            List<GetCouponRes> couponList = couponProvider.retrieveUserCoupon(userIdx);
            return new BaseResponse<List<GetCouponRes>>(couponList);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    {

    }
}
