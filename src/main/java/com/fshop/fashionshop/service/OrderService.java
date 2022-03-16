package com.fshop.fashionshop.service;

import com.fshop.fashionshop.model.Order;
import com.fshop.fashionshop.model.dto.request.OrderUpdateDto;

public interface OrderService {

    Order getByID(long id);

    Order update(long id, OrderUpdateDto orderUpdateDto);
}
