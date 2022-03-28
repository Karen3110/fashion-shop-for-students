package com.fshop.fashionshop.controller;

import com.fshop.fashionshop.model.Product;
import com.fshop.fashionshop.service.ImageService;
import com.fshop.fashionshop.service.ProductService;
import com.fshop.fashionshop.validation.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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


    @PostMapping(
//            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    ResponseEntity<Product> create(@RequestBody Product product, @RequestParam   MultipartFile[] images) {

//        return null;

//        ImageValidator.checkDefaultImage(product);

        if (!ProductValidator.validateCreateProduct(product)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "user data is invalid to create product"
            );
        }

        Product productFromDb = productService.create(product);

        productFromDb = imageService.saveImagesToFolder(productFromDb, images);


        return ResponseEntity.ok(productService.update(productFromDb.getId(), productFromDb));
    }

    @PutMapping("/{id}")
    ResponseEntity<Product> update(@PathVariable long id, @RequestBody Product product) {
        if (!ProductValidator.validateUpdateProduct(product)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "user data is invalid to update product with id:" + id
            );
        }
        return ResponseEntity.ok(productService.update(id, product));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable long id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }


}
