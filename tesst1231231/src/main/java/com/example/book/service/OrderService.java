package com.example.book.service;


import com.example.book.dto.OrderDTO;
import com.example.book.entity.OrderStatus;

import java.util.List;

public interface OrderService {
    OrderDTO saveOrder(OrderDTO orderDTO);
    OrderDTO getOrderById(long id);
    List<OrderDTO> getOrders();
    List<OrderDTO> getOrdersByUserId(String userId);
    OrderDTO getOrderByUsernameAndOrderId(long orderId); // Sửa lại nè ba ôkkk
    OrderDTO handleOrder(OrderStatus orderStatus, long id);
    OrderDTO cancelOrder(long id);

}
