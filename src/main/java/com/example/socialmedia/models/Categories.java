package com.example.socialmedia.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "categories", schema = "schema", catalog = "productDB")
public class Categories {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long categoriesId;
    @Column(name = "categoryname")
    private String categoryName;
}
