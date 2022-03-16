package com.fshop.fashionshop.controller;

import com.fshop.fashionshop.model.Order;
import com.fshop.fashionshop.model.dto.request.OrderUpdateDto;
import com.fshop.fashionshop.model.validation.dto.OrderDtoValidator;
import com.fshop.fashionshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable long id) {
        Order fromDb = orderService.getByID(id);
        return ResponseEntity.ok().body(fromDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@PathVariable long id, @RequestBody OrderUpdateDto orderUpdate) {
        if (!OrderDtoValidator.checkOrderUpdateRequest(orderUpdate)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "user data is invalid to update users order");
        }

        return ResponseEntity.ok().body(orderService.update(id, orderUpdate));
    }
}
