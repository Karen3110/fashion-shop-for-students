package com.fshop.fashionshop.service;

import com.fshop.fashionshop.model.Product;
import com.fshop.fashionshop.model.commons.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {


    Product saveImagesToFolder(long productId, MultipartFile[] images);

    List<byte[]> readAllByProductId(long productId);

    Image update(MultipartFile file);

    void delete(MultipartFile file);


}
