package com.example.demo.src.booking;

import com.example.demo.config.BaseException;
import com.example.demo.src.booking.model.Booking;
import com.example.demo.src.booking.model.BookingRepository;
import com.example.demo.src.booking.model.GetBookingListRes;
import com.example.demo.src.booking.model.GetBookingRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookingProvider {
    private final BookingRepository bookingRepository;

    @Transactional(readOnly = true)
    public List<GetBookingListRes> getBookingListById(Long userIdx) throws BaseException {
        return bookingRepository.findByUserIdxAndStatusOrderByCreatedAtDesc(userIdx,"ACTIVATED").stream().map(GetBookingListRes::new).collect(Collectors.toList());
    }
}
