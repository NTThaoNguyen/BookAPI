package com.example.book.dto;

import com.example.book.entity.Order;
import com.example.book.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;

    @NotBlank(message = "Name must be not blank")
    private String name;

    @NotBlank(message = "Address must be not blank")
    private String address;

    @NotBlank(message = "Phone must be not blank")
    private String phone;
    private Double total;
    private OrderStatus status;
    private LocalDateTime createdDate;

    @NotNull
    private String userId;
    @Size(min = 1)
    private List<OrderDetailDTO> orderDetails = new ArrayList<>();

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.name = order.getName();
        this.address = order.getAddress();
        this.phone = order.getPhone();
        this.total = order.getTotal();
        this.status = order.getStatus();
        this.createdDate = order.getCreatedDate();
        this.userId = order.getUser().getUsername();
        this.orderDetails = order.getOrderDetails().stream().map(OrderDetailDTO::new).collect(Collectors.toList());
    }

    public Order toEntity() {
        Order order = new Order();
        // id
        order.setName(this.name);
        order.setAddress(this.address);
        order.setPhone(this.phone);
        order.setTotal(this.total);
        order.setStatus(this.status);
        order.setCreatedDate(this.createdDate);
        return order;
    }

}
