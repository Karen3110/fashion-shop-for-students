package com.fshop.fashionshop.controller;

import com.fshop.fashionshop.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/image")
public class ImageController {
    private final String IMG_URL_MAPPER_POST_FIX = "/get";

    @Autowired
    private ImageService imageService;

    @PostMapping("/add/{product_id}")
    String addImage(@PathVariable("product_id") long productId, @RequestParam("image") MultipartFile[] multipartFile) {

        String serverUrl = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
        String requestMapping = this.getClass().getAnnotation(RequestMapping.class).value()[0];


        String imageMappingPath = serverUrl + '/' + requestMapping;

        imageService.saveImagesToFolder(productId, multipartFile, imageMappingPath + IMG_URL_MAPPER_POST_FIX);
        return "added";
    }

    @GetMapping(value = "/get/{folder_name}/{img_name}")
    ResponseEntity<byte[]> getImagesByProductId(@PathVariable("folder_name") String folderName, @PathVariable("img_name") String imageName) throws IOException {

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(imageService.readByFolderNameAndImageName(folderName, imageName));
    }


}
