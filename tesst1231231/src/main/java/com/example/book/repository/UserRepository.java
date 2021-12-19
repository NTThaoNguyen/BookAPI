package com.example.book.repository;

import com.example.book.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    Boolean existsByCMND(String CMND);
    Boolean existsByEmail(String email);
    Boolean existsByPhone(String phone);
}
