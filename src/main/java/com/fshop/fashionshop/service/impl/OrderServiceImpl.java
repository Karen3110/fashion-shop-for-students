package com.fshop.fashionshop.service.impl;

import com.fshop.fashionshop.model.Order;
import com.fshop.fashionshop.model.dto.request.OrderUpdateDto;
import com.fshop.fashionshop.repository.OrderRepository;
import com.fshop.fashionshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order getByID(long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "order with this id:" + id + "  not found in database"));
    }

    @Override
    @Transactional
    public Order update(long id, OrderUpdateDto orderUpdateDto) {
        Order fromDb = orderRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "order with this id:" + id + "  not found in database to update object"));
        fromDb.setOrderStatus(orderUpdateDto.getOrderStatus());
        fromDb.setCount(orderUpdateDto.getCount());
        return fromDb;

    }
}
