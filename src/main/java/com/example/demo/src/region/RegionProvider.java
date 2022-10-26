package com.example.demo.src.region;

import com.example.demo.config.BaseException;
import com.example.demo.src.region.model.GetRegionRes;
import com.example.demo.src.region.model.RegionRepository;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
public class RegionProvider {

    private final RegionRepository regionRepository;

    @Transactional(readOnly = true)
    public List<GetRegionRes> retrieveRegionList() throws BaseException {

        List<GetRegionRes> regionList = regionRepository.findByStatusOrderByIdxAsc("ACTIVATED").stream()
                .map(GetRegionRes::new)
                .collect(Collectors.toList());

        return regionList;

    }


}
