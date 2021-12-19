package com.example.book.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "username")
    private String username;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "username")
    private Account account;
    private String CMND;
    private String fullName;
    private String address;
    private String phone;
    private String email;


}
