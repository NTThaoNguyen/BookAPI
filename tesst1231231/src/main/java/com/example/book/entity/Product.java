package com.example.book.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    //@Column(name = "unit")
    //private String unit;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "description", columnDefinition="TEXT")
    private String description;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images = new ArrayList<>();
    //---------CAU HINH CAC MOI QUAN HE------------
    //QH N-1 between BOOK with CATEGORY
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    //QH N-1 between BOOK with NXB
    @ManyToOne
    @JoinColumn(name = "idNXB")
    private NXB nxb;
    //QH N-1 between BOOK with AUTHOR
    @ManyToOne
    @JoinColumn(name = "idTG")
    private Author author;

}
