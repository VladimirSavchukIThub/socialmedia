package com.example.socialmedia.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "orderdetails", schema = "schema", catalog = "productDB")
public class OrderDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long detailId;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "unitprice")
    private int unitPrice;

    @ManyToOne
    @JoinColumn(name = "productsId")
    private Products products;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Orders orders;
}
