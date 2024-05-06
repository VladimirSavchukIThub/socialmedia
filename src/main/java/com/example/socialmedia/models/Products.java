package com.example.socialmedia.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

@Entity
@Data
@Table(name = "products", schema = "schema", catalog = "productDB")
public class Products {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long productsId;
    @Column(name = "productname")
    private String productName;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "categoriesId")
    private Categories categories;
}
