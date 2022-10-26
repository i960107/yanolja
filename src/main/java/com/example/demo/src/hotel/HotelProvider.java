package com.example.demo.src.hotel;

import com.example.demo.config.BaseException;
import com.example.demo.config.Status;
import com.example.demo.src.hotel.model.GetHotelListRes;
import com.example.demo.src.hotel.model.GetHotelRes;
import com.example.demo.src.hotel.model.GetHotelRoomRes;
import com.example.demo.src.hotel.model.HotelRoomRepository;
import com.example.demo.src.hotel.model.entity.Hotel;
import com.example.demo.src.hotel.model.entity.HotelRepository;
import com.example.demo.src.hotel.model.entity.HotelRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.config.BaseResponseStatus.ACCOMMODATION_IDX_ERROR;
import static com.example.demo.config.BaseResponseStatus.ACCOMMODATION_ROOM_IDX_ERROR;

@RequiredArgsConstructor
@Service
public class HotelProvider {
    private final HotelRepository hotelRepository;
    private final HotelRoomRepository hotelRoomRepository;

    @Transactional(readOnly = true)
    public List<GetHotelListRes> retrieveHotelList(Long tagIdx, byte people, LocalDate checkIn, LocalDate checkOut, Long regionIdx, String sort) throws BaseException {

        List<GetHotelListRes> hotelList = hotelRepository.
                findByMaxPeopleGreaterThanEqualAndRegionIdxIsAndStatus(
                        people, regionIdx ,Status.ACTIVATED,Sort.by(Sort.Direction.DESC, sort))

                .stream().map(GetHotelListRes::new).collect(Collectors.toList());

        return hotelList;

    }

    @Transactional(readOnly = true)
    public GetHotelRes retrieveHotel(Long idx) throws BaseException {

        Hotel hotel = hotelRepository.findByIdxAndStatus(idx, Status.ACTIVATED)
                .orElseThrow(() -> new BaseException(ACCOMMODATION_IDX_ERROR));

        return new GetHotelRes(hotel);

    }

    @Transactional(readOnly = true)
    public List<GetHotelRoomRes> retrieveHotelRoomList(Long hotelIdx) throws BaseException {

        List<GetHotelRoomRes> hotelRoomList = hotelRoomRepository.findByHotelIdxAndStatusOrderByOrderAsc(hotelIdx, "ACTIVATED")
                .stream().map(GetHotelRoomRes::new).collect(Collectors.toList());

        return hotelRoomList;
    }

    @Transactional(readOnly = true)
    public GetHotelRoomRes retrieveHotelRoom(Long hotelIdx, Long roomIdx) throws BaseException {
        hotelRepository.findByIdxAndStatus(hotelIdx, Status.ACTIVATED)
                .orElseThrow(() -> new BaseException(ACCOMMODATION_IDX_ERROR));

        HotelRoom hotelRoom = hotelRoomRepository.findByIdxAndStatusOrderByOrderAsc(roomIdx, "ACTIVATED")
                .orElseThrow(() -> new BaseException(ACCOMMODATION_ROOM_IDX_ERROR));

        return new GetHotelRoomRes(hotelRoom);
    }

}
