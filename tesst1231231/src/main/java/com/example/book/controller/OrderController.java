package com.example.book.controller;

import com.example.book.dto.OrderDTO;
import com.example.book.entity.OrderStatus;
import com.example.book.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/orders")
    public OrderDTO addOrder(@Valid @RequestBody OrderDTO orderDTO) {
        return orderService.saveOrder(orderDTO);
    }

    @GetMapping("/orders")
    public List<OrderDTO> getOrders(@RequestParam(name="username",required = false) String username) {
        if(username==null)return orderService.getOrders();
        return orderService.getOrdersByUserId(username);
    }
    @GetMapping("/orders/{id}")
    public OrderDTO getOrderById(@PathVariable long id) {
        return orderService.getOrderById(id);
    }


    @PutMapping("/orders/{id}")
    public OrderDTO handleOrder(@Valid @RequestBody OrderStatus orderStatus, @PathVariable long id) {
        return orderService.handleOrder(orderStatus, id);
    }

    @DeleteMapping("/orders/{orderId}")
    public OrderDTO cancelOrder(@PathVariable long orderId) {
        return orderService.cancelOrder(orderId);
    }

}
