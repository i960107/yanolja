package com.example.demo.src.motel;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.motel.model.GetMotelRes;
import com.example.demo.src.motel.model.GetMotelRoomRes;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/motel")
public class MotelController {
    private final MotelProvider motelProvider;
    private final MotelService motelService;

//    @ResponseBody @GetMapping("")
//    public BaseResponse<List<GetMotelRes>> retrieveMotelList
//            (
//                    @RequestParam("tagIdx") Long tagIdx,
//                    @RequestParam("people") byte people,
//                    @RequestParam("checkIn") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkIn,
//                    @RequestParam("checkOut") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkOut,
//                    @RequestParam("regionIdx") Long regionIdx,
//                    @RequestParam("sort") String sort
//            ) {
//
//        try {
//
//            List<GetMotelRes> motelList = motelProvider.retrieveMotelList(tagIdx, people, checkIn, checkOut, regionIdx, sort);
//            return new BaseResponse<List<GetMotelRes>>(motelList);
//
//        } catch (BaseException exception) {
//
//            return new BaseResponse<>(exception.getStatus());
//
//        }
//
//    }

    @ResponseBody
    @GetMapping("/{motelIdx}")
    public BaseResponse<GetMotelRes> retrieveMotel(@PathVariable("motelIdx") Long motelIdx) {
        try{

            return new BaseResponse<GetMotelRes>(motelProvider.retrieveMotel(motelIdx));

        }catch(BaseException exception){

            return new BaseResponse<>(exception.getStatus());

        }
    }

    @ResponseBody
    @GetMapping("/{motelIdx}/room")
    public BaseResponse<List<GetMotelRoomRes>> retrieveMotelRoomList(
            @PathVariable("motelIdx") Long motelIdx
    ) {
        try{

            return new BaseResponse<List<GetMotelRoomRes>>(
                    motelProvider.retrieveMotelRoomList(motelIdx)
            );

        }catch(BaseException exception){

            return new BaseResponse<>(exception.getStatus());

        }
    }

    @ResponseBody
    @GetMapping("/{motelIdx}/room/{roomIdx}")
    public BaseResponse<GetMotelRoomRes> retrieveMotelRoom(
            @PathVariable("motelIdx") Long motelIdx,
            @PathVariable("roomIdx") Long motelRoomIdx
    ) {
        try{

            return new BaseResponse<GetMotelRoomRes>(
                    motelProvider.retrieveMotelRoom(motelIdx, motelRoomIdx)
            );

        }catch(BaseException exception){

            return new BaseResponse<>(exception.getStatus());

        }
    }
}
