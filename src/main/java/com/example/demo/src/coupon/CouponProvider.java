package com.example.demo.src.coupon;

import com.example.demo.config.BaseException;
import com.example.demo.src.coupon.model.CouponRepository;
import com.example.demo.src.coupon.model.GetCouponRes;
import com.example.demo.src.users.user.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.config.BaseResponseStatus.USERS_EMPTY_USER_IDX;

@RequiredArgsConstructor
@Service
public class CouponProvider {
    private final CouponRepository couponRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<GetCouponRes> retrieveUserCoupon(Long userIdx) throws BaseException {
        userRepository.findById(userIdx).orElseThrow(()->new BaseException(USERS_EMPTY_USER_IDX));

        List<GetCouponRes> couponList = couponRepository
                .findListByUserIdx(userIdx).stream()
                .map(GetCouponRes::new)
                .collect(Collectors.toList());

        return couponList;
    }
}
