package com.fshop.fashionshop.service;

import com.fshop.fashionshop.model.Product;
import com.fshop.fashionshop.model.commons.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {


    Product saveImagesToFolder(Product product, MultipartFile[] images);

    Image read(MultipartFile file);

    Image update(MultipartFile file);

    void delete(MultipartFile file);


}
