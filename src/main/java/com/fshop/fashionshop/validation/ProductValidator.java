package com.fshop.fashionshop.validation;

import com.fshop.fashionshop.model.Product;
import com.fshop.fashionshop.validation.commons.DescriptionValidator;
import com.fshop.fashionshop.validation.commons.StockValidator;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public final class ProductValidator {
    public static void validateUpdateProduct(Product product, HttpStatus status, String message) {
        if (product.getName().length() == 0 ||
                product.getPrice() < 0 ||
                !StockValidator.validateStock(product.getStock()) ||
                !DescriptionValidator.validateDescription(product.getDescription())) {
            throw new ResponseStatusException(status, message);
        }


    }

    public static void validateCreateProduct(Product product, HttpStatus status, String message) {
        validateUpdateProduct(product, status, message);
    }


}
