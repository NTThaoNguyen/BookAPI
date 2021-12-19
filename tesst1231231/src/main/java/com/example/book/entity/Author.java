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
@Table(name="Author")
public class Author {
    @Id
    @Column(name = "maTG")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maTG;
    @Column(name = "tenTG")
    private String tenTG;
    //QH 1-N with book
    @OneToMany(mappedBy = "author")
    List<Product> author =new ArrayList<>();

}
