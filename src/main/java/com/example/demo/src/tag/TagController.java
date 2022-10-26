package com.example.demo.src.tag;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.tag.model.GetTagRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tag")
public class TagController {

    private final TagProvider tagProvider;
    private final TagService tagService;

    @GetMapping("")
    @ResponseBody
    public BaseResponse<List<GetTagRes>> retrieveTagList(
            @RequestParam("accommodationType") String accommodationType
    ){

        try{
            return new BaseResponse<List<GetTagRes>>(tagProvider.retrieveTagList(accommodationType));
        }catch(BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }

    }
}
