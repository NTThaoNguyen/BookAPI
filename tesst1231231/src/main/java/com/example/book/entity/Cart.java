package com.example.book.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Cart")
public class Cart {
    @Id
    @Column(name = "maGio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maGio;
    @Column(name = "tien")
    private float tien;
//    //QH N-N between CART with BOOK
//    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
//    private List<CartDetails> books = new ArrayList<>();
}
