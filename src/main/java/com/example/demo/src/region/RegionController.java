package com.example.demo.src.region;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.region.model.GetRegionRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/region")
public class RegionController {

    private final RegionProvider regionProvider;
    private final RegionService regionService;

    @ResponseBody
    @GetMapping("")
    public BaseResponse<List<GetRegionRes>> retrieveRegionList(){

        try{

            return new BaseResponse<List<GetRegionRes>>(regionProvider.retrieveRegionList());

        }catch(BaseException exception){

            return new BaseResponse<>(exception.getStatus());

        }
    }
}
