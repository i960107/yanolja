package com.example.demo.src.region.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetRegionRes {
    private Long idx;
    private String regionDepth1;
    private String regionDepth2;

    public GetRegionRes(Region region){
        this.idx=region.getIdx();
        this.regionDepth1=region.getRegionDepth1();
        this.regionDepth2=region.getRegionDepth2();
    }

}
