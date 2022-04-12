package com.fshop.fashionshop.service.impl;

import com.fshop.fashionshop.model.Order;
import com.fshop.fashionshop.model.Product;
import com.fshop.fashionshop.model.commons.enums.OrderStatus;
import com.fshop.fashionshop.model.dto.requestDto.OrderUpdateReqDto;
import com.fshop.fashionshop.repository.OrderRepository;
import com.fshop.fashionshop.service.OrderService;
import com.fshop.fashionshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    /***
     *
     * @param order is the product that will be added in DB
     * @return new product which has added
     */
    @Override
    public Order create(Order order) {
        order.setOrderStatus(OrderStatus.UNPAID);
        return orderRepository.save(order);
    }

    /***
     *
     * @param id with the help of it will find the object from DB.
     *           •
     * @return returns founded object or throws @ResponseStatusException(BAD_REQUEST).
     */

    @Override
    public List<Order> getAllById(String id) {
        return orderRepository
                .getAllByUserId(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Orders with user_id:" + id + "  not found in database")
                );
    }

    /***
     *
     * @return all data from DB, if there is not any data will return empty List.
     */
    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(long orderId) {
        return orderRepository.findById(orderId).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "order with id:" + orderId + "  not found in database")
        );

    }

    @Transactional
    @Override
    public Order update(String id, OrderUpdateReqDto reqDto) {
//        Order fromDb = orderRepository
//                .findById(id)
//                .orElseThrow(() -> new ResponseStatusException(
//                        HttpStatus.BAD_REQUEST,
//                        "order with id:" + id + "  not found in database")
//                );
//        fromDb.setCount(reqDto.getCount());
//        fromDb.setOrderStatus(reqDto.getOrderStatus());
//
//        return fromDb;
        return null;
    }


    @Override
    @Transactional
    public void changeStatus(Long orderId, OrderStatus orderStatus) {
        Order fromDb = orderRepository.findById(orderId).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Order with id:" + orderId + "  not found in database"));


        Product product = productService.getById(fromDb.getProduct().getId());

        product.updateStock(fromDb.getOrderStatus(), orderStatus, fromDb.getCount());
        fromDb.setOrderStatus(orderStatus);
    }

    @Override
    public void delete(String id) {

    }
}
