package com.example.demo.src.bookmark;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.bookmark.model.GetBookmarkListRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/bookmark")
public class BookmarkController {
    private final BookmarkProvider bookmarkProvider;
    private final BookmarkService bookmarkService;

    @GetMapping("/{userIdx}")
    @ResponseBody
    public BaseResponse<List<GetBookmarkListRes>> getBookmarkListByUserIdx(@PathVariable(name="userIdx", required = true) Long userIdx) {
        try {
            return new BaseResponse<List<GetBookmarkListRes>>(bookmarkProvider.getBookmarkListByUserIdx(userIdx));
        }catch(BaseException baseException){
            return new BaseResponse<>(baseException.getStatus());
        }
    }
}
