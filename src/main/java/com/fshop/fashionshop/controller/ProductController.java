package com.fshop.fashionshop.controller;

import com.fshop.fashionshop.model.Product;
import com.fshop.fashionshop.service.ImageService;
import com.fshop.fashionshop.service.ProductService;
import com.fshop.fashionshop.validation.ProductValidator;
import com.fshop.fashionshop.validation.UserValidator;
import com.fshop.fashionshop.validation.ValidationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ImageService imageService;

    @GetMapping("/{id}")
    ResponseEntity<Product> getById(@PathVariable long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @GetMapping()
    ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }


    @PostMapping
    ResponseEntity<Product> create(@RequestBody Product product) {
//        UserValidator.checkUserAuthorized("1234",HttpStatus.UNAUTHORIZED, ValidationConstants.UNAUTHORIZED_ERROR);
        ProductValidator.validateCreateProduct(product, HttpStatus.BAD_REQUEST, "product data is invalid to add in DB");

        return ResponseEntity.ok(productService.create(product));
    }

    @PutMapping("/{id}")
    ResponseEntity<Product> update(@PathVariable long id, @RequestBody Product product) {
        UserValidator.checkUserAuthorized("12345",HttpStatus.UNAUTHORIZED, ValidationConstants.UNAUTHORIZED_ERROR);
        ProductValidator.validateUpdateProduct(product, HttpStatus.BAD_REQUEST, "products data that you want to update does not matches to the product structure");

        return ResponseEntity.ok(productService.update(id, product));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable long id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }


}
