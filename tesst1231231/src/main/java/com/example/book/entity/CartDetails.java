package com.example.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CartDetails")
public class CartDetails {
    @Id
    private int id;
    @Column(name = "soLuong")
    private float soLuong;

}
