package com.fshop.fashionshop.model.validation.dto;

import com.fshop.fashionshop.model.commons.enums.OrderStatus;
import com.fshop.fashionshop.model.dto.request.OrderUpdateDto;

import java.util.Arrays;

public final class OrderDtoValidator {
    public static final boolean checkOrderUpdateRequest(OrderUpdateDto orderUpdateDto) {
        boolean b = Arrays.stream(OrderStatus.values()).anyMatch(orderStatus -> orderStatus == orderUpdateDto.getOrderStatus());
        if (orderUpdateDto.getCount() < 0 || orderUpdateDto.getCount() > 100 && b) {
            return false;
        }
        return true;
    }
}
