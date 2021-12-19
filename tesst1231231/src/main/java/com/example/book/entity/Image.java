package com.example.book.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Image")
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "url")
    private String url;
    //Nhap
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
