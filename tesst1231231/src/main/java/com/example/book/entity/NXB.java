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
@Table(name="NXB")
public class NXB {
    @Id
    @Column(name = "maNXB")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maNXB;
    @Column(name = "tenNXB")
    private String tenNXB;
    @Column(name = "diaChi")
    private String address;
    @Column(name = "SDT")
    private String SDT;
    //QH 1-N between NXB with BOOK
    @OneToMany(mappedBy = "nxb")
    List<Product> nxb =new ArrayList<>();
}
