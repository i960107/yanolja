package com.example.demo.src.tag;

import com.example.demo.config.BaseException;
import com.example.demo.src.tag.model.GetTagRes;
import com.example.demo.src.tag.model.TagRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.config.BaseResponseStatus.ACCOMMODATION_TYPE_ERROR;

@RequiredArgsConstructor
@Service
public class TagProvider {

    private final TagRepository tagRepository;

    public List<GetTagRes> retrieveTagList(String accommodationType) throws BaseException {

        if(!accommodationType.equals("호텔") && !accommodationType.equals("모텔")){
            throw new BaseException(ACCOMMODATION_TYPE_ERROR);
        }

        return  tagRepository.findByAccommodationTypeAndStatus(accommodationType,"ACTIVATED")
                    .stream().map(GetTagRes::new).collect(Collectors.toList());


    }
}
