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
@Table(name="TheLoai")
public class Category {
    @Id
    @Column(name = "maTL")
    private String maTL; // String not Int :))))
    //dao ni nho bo cu hơi lag :)))
    @Column(name = "tenTL")
    private String name;
    //QH 1-N between CATEGORY with BOOK
    @OneToMany(mappedBy = "category")
    List<Product> category =new ArrayList<>();
}
