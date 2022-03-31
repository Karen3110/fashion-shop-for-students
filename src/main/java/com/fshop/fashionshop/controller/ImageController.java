package com.fshop.fashionshop.controller;

import com.fshop.fashionshop.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/add/{product_id}")
    void addImage(@PathVariable("product_id") long productId, @RequestParam("image") MultipartFile[] multipartFile) {

        imageService.saveImagesToFolder(productId, multipartFile);
    }

    @GetMapping(value = "/get/{product_id}",
            produces = MediaType.IMAGE_PNG_VALUE
    )
    ResponseEntity<List<byte[]>> getImagesByProductId(@PathVariable("product_id") long productId) {

        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imageService.readAllByProductId(productId));

    }
}
