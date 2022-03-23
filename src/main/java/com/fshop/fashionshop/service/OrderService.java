package com.fshop.fashionshop.service;

import com.fshop.fashionshop.model.Order;
import com.fshop.fashionshop.model.dto.requestDto.OrderUpdateReqDto;

import java.util.List;

public interface OrderService {

    Order create(Order order);

    Order getAllById(long id);

    List<Order> getAll();

    Order update(long id, OrderUpdateReqDto order);

    void delete(long id);
}
