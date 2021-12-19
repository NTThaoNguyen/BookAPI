package com.example.book.repository;


import com.example.book.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory_MaTL(String maTL);
}
