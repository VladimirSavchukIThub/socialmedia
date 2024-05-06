package com.example.socialmedia.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "orders", schema = "schema", catalog = "productDB")
public class Orders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long orderId;
    @Column(name = "orderdate")
    private Date orderDate;
    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
