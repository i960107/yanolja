package com.example.demo.src.motel;

import com.example.demo.config.BaseException;
import com.example.demo.src.motel.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.config.BaseResponseStatus.*;

@RequiredArgsConstructor
@Service
public class MotelProvider {

    private final MotelRepository motelRepository;
    private final MotelRoomRepository motelRoomRepository;

//    @Transactional(readOnly = true)
//    public List<GetMotelRes> retrieveMotelList(Long tagIdx, byte people, LocalDate checkIn, LocalDate checkOut, Long regionIdx, String sort) throws BaseException {
//        List<GetMotelRes> motelList = motelRepository.findListBy(
//                tagIdx,
//                people,
//                regionIdx,
//                Sort.by(Sort.Direction.DESC, sort)
//        ).stream().map(GetMotelRes::new).collect(Collectors.toList());
//
//        return motelList;
//
//    }

    @Transactional(readOnly = true)
    public GetMotelRes retrieveMotel(Long tagIdx) throws BaseException {

        Motel motel = motelRepository.findByIdxAndStatus(tagIdx, "ACTIVATED")
                .orElseThrow(() -> new BaseException(ACCOMMODATION_IDX_ERROR));

        return new GetMotelRes(motel);

    }

    @Transactional(readOnly = true)
    public List<GetMotelRoomRes> retrieveMotelRoomList(Long motelIdx) throws BaseException {
        motelRepository.findByIdxAndStatus(motelIdx,"ACTIVATED")
                .orElseThrow(()->new BaseException(ACCOMMODATION_IDX_ERROR));

        List<GetMotelRoomRes> motelRoomList = motelRoomRepository.findByMotelIdxAndStatusOrderByOrderAsc(motelIdx,"ACTIVATED")
                .stream().map(GetMotelRoomRes::new)
                .collect(Collectors.toList());

        return motelRoomList;

    }

    @Transactional(readOnly = true)
    public GetMotelRoomRes retrieveMotelRoom(Long motelIdx, Long roomIdx) throws BaseException {
        motelRepository.findByIdxAndStatus(motelIdx,"ACTIVATED")
                .orElseThrow(()->new BaseException(ACCOMMODATION_IDX_ERROR));

        MotelRoom motelRoom = motelRoomRepository.findByIdxAndMotelIdxAndStatus(roomIdx, motelIdx, "ACTIVATED")
                    .orElseThrow(() -> new BaseException(ACCOMMODATION_ROOM_IDX_ERROR));

        return new GetMotelRoomRes(motelRoom);

    }
}


