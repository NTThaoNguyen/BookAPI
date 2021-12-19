package com.example.book.repository;

import com.example.book.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser_Username(String username);// khi mà em chạy cái này nó sẽ đưa tra 1 list order của thằng
    //username nguyen ---> Trên UI hiển thị ra các Order
    //sau khi nhấn click vào order (thì hiện ra chi tiết của order đó) tức là Chỉ cần tìm với cái OrderID thôi
    // Nên không cần username chỗ này làm cái gì cả // Hiểu k ? hiểu
}
/*
* Tức là vầy
* Order 1  id 1
* Order 2 id 2
* Order 3 id 3  (Click select ID 5 )-> gọi (findByOrderId( 3) OKie
* Order 4 id 4
* Order 5 id 5
*
*
* */