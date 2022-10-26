package com.example.demo.src.tag.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetTagRes {
    private Long idx;
    private String name;

    public GetTagRes(Tag tag) {
        this.idx = tag.getIdx();
        this.name = tag.getName();
    }
}
