package com.fshop.fashionshop.controller;

import com.fshop.fashionshop.model.Product;
import com.fshop.fashionshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable long id) {

        Product fromDb = productService.getByID(id);

        return ResponseEntity.ok().body(fromDb);
    }
}
