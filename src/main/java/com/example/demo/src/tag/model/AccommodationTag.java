package com.example.demo.src.tag.model;

import com.example.demo.config.BaseTimeEntity;
import com.example.demo.src.hotel.model.entity.Hotel;
import lombok.Generated;
import lombok.Getter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Entity
@Table(name="accommodation_tag")
public class AccommodationTag extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String accommodationType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelIdx")
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tagIdx")
    @Where(clause = "status = 'ACTIVATED")
    private Tag tag;

    @Column
    private Long accommodationIdx;
//    @Column
//    private Tag tag;
    @Column
    private String status;
}
