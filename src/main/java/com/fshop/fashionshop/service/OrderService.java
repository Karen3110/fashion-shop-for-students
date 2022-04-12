package com.fshop.fashionshop.service;

import com.fshop.fashionshop.model.Order;
import com.fshop.fashionshop.model.commons.enums.OrderStatus;
import com.fshop.fashionshop.model.dto.requestDto.OrderUpdateReqDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderService {

    Order create(Order order);

    List<Order> getAllById(String id);

    List<Order> getAll();

    Order getOrderById(long orderId);

    Order update(String id, OrderUpdateReqDto order);

    @Transactional
    void changeStatus(Long orderId, OrderStatus orderStatus);

    void delete(String id);
}
