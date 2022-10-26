package com.example.demo.src.review.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
public class GetRatingRes {
    private Integer count;
    private Float rating;
    private Float cleanliness;
    private Float kindness;
    private Float convenience;
    private Float locationSatisfaction;

    public GetRatingRes(
            Integer count,
            Float cleanliness,
            Float kindness,
            Float convenience,
            Float locationSatisfaction,
            Float rating
    ) {
        this.count = count;
        this.rating = rating;
        this.cleanliness = cleanliness;
        this.kindness = kindness;
        this.convenience = convenience;
        this.locationSatisfaction = locationSatisfaction;
    }
}
