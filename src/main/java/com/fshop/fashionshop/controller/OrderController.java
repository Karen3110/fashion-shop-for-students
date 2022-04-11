package com.fshop.fashionshop.controller;

import com.fshop.fashionshop.model.Order;
import com.fshop.fashionshop.model.dto.requestDto.OrderUpdateReqDto;
import com.fshop.fashionshop.service.OrderService;
import com.fshop.fashionshop.validation.OrderValidator;
import com.fshop.fashionshop.validation.ProductValidator;
import com.fshop.fashionshop.validation.UserValidator;
import com.fshop.fashionshop.validation.ValidationConstants;
import com.fshop.fashionshop.validation.dto.OrderDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/user-order")
    ResponseEntity<List<Order>> getById(@RequestHeader("user_id") String userId) {

        UserValidator.checkUserAuthorized(userId, HttpStatus.UNAUTHORIZED, "user is UNAUTHORIZED, plz SignUp at first");

        return ResponseEntity.ok(orderService.getAllById(userId));

    }


    @PostMapping
    ResponseEntity<Order> create(@RequestBody Order order) {

        UserValidator.checkUserAuthorized(order.getUser().getId(), HttpStatus.UNAUTHORIZED, ValidationConstants.UNAUTHORIZED_ERROR);
        ProductValidator.validateCreateProduct(order.getProduct(), HttpStatus.BAD_REQUEST, ValidationConstants.ORDER_ERROR_PRODUCT);
        OrderValidator.validateOrder(order, HttpStatus.BAD_REQUEST, "validation for order failed, plz check order description");

        return ResponseEntity.ok(orderService.create(order));

    }


    @PutMapping("/{user_id}/{order_id}")
    Order update(@PathVariable("user_id") String userId, @PathVariable("order_id") String orderId, OrderUpdateReqDto reqDto) {
        if (!OrderDtoValidator.chekOrderUpdateDto(reqDto)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "user data is invalid to update users order"
            );
        }
        UserValidator.checkUserAuthorized(userId, HttpStatus.UNAUTHORIZED, "user is UNAUTHORIZED, plz SignUp at first");

        return orderService.update(orderId, reqDto);
    }

}
