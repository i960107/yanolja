package com.example.demo.src.image.model.entity;

import com.example.demo.config.BaseTimeEntity;
import com.example.demo.config.Status;
import com.example.demo.src.hotel.model.entity.Hotel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@SQLDelete(sql="UPDATE `hotel_image` SET status = 'DELETED' WHERE idx = ? ")
@Table(name = "hotel_image")
public class HotelImage extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

//    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name="imageIdx", referencedColumnName = "idx")
//    Image image;



    @Column(columnDefinition = "varchar(1000)", nullable = true)
    private String imageUrl;

    @Column(columnDefinition = "tinyint", nullable = true)
    private byte position;

    @Column(columnDefinition = "varchar(10) default 'ACTIVATED'", nullable =true)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Setter
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "hotelIdx", columnDefinition = "int unsigned", nullable = true)
    private Hotel hotel;

    @Builder
    public HotelImage(Long idx, String imageUrl, byte order, Status status, Hotel hotel) {
        this.idx = idx;
        this.imageUrl = imageUrl;
        this.position = order;
        this.status = status;
    }
}
