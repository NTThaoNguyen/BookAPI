package com.example.book.entity;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(unique = true)
    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private User user;
}
