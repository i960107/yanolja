package com.example.demo.src.review.model;

import com.example.demo.config.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "review")
@NamedNativeQuery(
        name = "findRating",
        query = "select " +
                "count(*) as count, " +
                "avg(r.cleanliness) as cleanliness, " +
                "avg(r.kindness) as kindness, " +
                "avg(r.convenience) as convenience, " +
                "avg(r.locationSatisfaction) as locationSatisfaction, " +
                "avg((r.cleanliness+r.kindness+r.convenience+r.locationSatisfaction)/4) as rating " +
                "from review r " +
                "where r.createdAt >= DATE_ADD(Now(),interval - 12 month) " +
                "and r.accommodationType = :accommodationType " +
                "and r.accommodationIdx = :accommodationIdx",
        resultSetMapping = "findRatingResult"
)
@SqlResultSetMapping(
        name = "findRatingResult",
        classes= {
        @ConstructorResult(targetClass = GetRatingRes.class,
                columns = {
                        @ColumnResult(name = "count", type = Integer.class),
                        @ColumnResult(name = "cleanliness", type = Float.class),
                        @ColumnResult(name = "kindness", type = Float.class),
                        @ColumnResult(name = "convenience", type = Float.class),
                        @ColumnResult(name = "locationSatisfaction", type = Float.class),
                        @ColumnResult(name = "rating", type = Float.class),
                }
        )
}

)
public class Review extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String accommodationType;

    @Column
    private Long accommodationIdx;

    @Column
    private Long roomIdx;

    @Column
    private Long bookingIdx;

    @Column
    private Long userIdx;

    @Column
    private byte kindness;

    @Column
    private byte cleanliness;

    @Column
    private byte convenience;

    @Column
    private byte locationSatisfaction;

    @Column
    private String imageUrl1;

    @Column
    private String imageUrl2;

    @Column
    private String imageUrl3;

    @Column
    private String content;

    @Column
    private float rating;

    @Column
    private String status;

    @Builder
    public Review(String accommodationType, Long accommodationIdx, Long roomIdx, Long bookingIdx,
                  Long userIdx, byte kindness, byte cleanliness, byte convenience, byte locationSatisfaction,
                  String imageUrl1, String imageUrl2, String imageUrl3, String content, float rating, String status) {
        this.accommodationType = accommodationType;
        this.accommodationIdx = accommodationIdx;
        this.roomIdx = roomIdx;
        this.bookingIdx = bookingIdx;
        this.userIdx = userIdx;
        this.kindness = kindness;
        this.cleanliness = cleanliness;
        this.convenience = convenience;
        this.locationSatisfaction = locationSatisfaction;
        this.imageUrl1 = imageUrl1;
        this.imageUrl2 = imageUrl2;
        this.imageUrl3 = imageUrl3;
        this.content = content;
        this.rating = rating;
        this.status = status;
    }
}
