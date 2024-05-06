package com.example.socialmedia.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "reviews", schema = "schema", catalog = "productDB")
public class Reviews {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long reviewId;
    @Column(name = "rating")
    private int rating;
    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne
    @JoinColumn(name = "productsId")
    private Products products;
}
