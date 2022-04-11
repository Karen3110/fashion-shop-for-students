package com.fshop.fashionshop.validation;

import com.fshop.fashionshop.model.Order;
import com.fshop.fashionshop.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public final class OrderValidator {
    public static void validateOrder(Order order, HttpStatus status, String message) {
        if (
                !(order.getCount() > ValidationConstants.ORDER_PRODUCT_COUNT_MIN_VALUE &&
                        order.getCount() <= ValidationConstants.ORDER_PRODUCT_COUNT_MAX_VALUE
                ) ||
                order.getDate() == 0) {

            throw new ResponseStatusException(status,message);
        }
    }
}
