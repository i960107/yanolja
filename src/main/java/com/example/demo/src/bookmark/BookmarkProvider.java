package com.example.demo.src.bookmark;

import com.example.demo.config.BaseException;
import com.example.demo.src.bookmark.model.Bookmark;
import com.example.demo.src.bookmark.model.BookmarkRepository;
import com.example.demo.src.bookmark.model.GetBookmarkListRes;
import com.example.demo.src.hotel.model.entity.Hotel;
import com.example.demo.src.hotel.model.entity.HotelRepository;
import com.example.demo.src.motel.model.Motel;
import com.example.demo.src.motel.model.MotelRepository;
import com.example.demo.src.users.user.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.config.BaseResponseStatus.USERS_EMPTY_USER_IDX;

@RequiredArgsConstructor
@Service
public class BookmarkProvider {
    private final BookmarkRepository bookmarkRepository;
    private final UserRepository userRepository;
    private final HotelRepository hotelRepository;
    private final MotelRepository motelRepository;

    @Transactional(readOnly = true)
    public List<GetBookmarkListRes> getBookmarkListByUserIdx(Long userIdx) throws BaseException {
        userRepository.findById(userIdx).orElseThrow(() ->new BaseException(USERS_EMPTY_USER_IDX));
        List<Bookmark> bookmarkEntity = bookmarkRepository.findByUserIdxAndStatusOrderByCreatedAt(userIdx, "ACTIVATED");

        List<GetBookmarkListRes> bookmarkList = new ArrayList<GetBookmarkListRes>();
        for (Bookmark bookmark : bookmarkEntity) {
            if (bookmark.getAccommodationType().equals("호텔")) {
                Hotel hotel = hotelRepository.findById(bookmark.getAccommodationIdx()).orElse(null);
                bookmarkList.add(new GetBookmarkListRes(bookmark, hotel));
            } else if (bookmark.getAccommodationType().equals("모텔")) {
                Motel motel = motelRepository.findById(bookmark.getAccommodationIdx()).orElse(null);
                bookmarkList.add(new GetBookmarkListRes(bookmark, motel));
            }
        }

        return bookmarkList;
    }
}
