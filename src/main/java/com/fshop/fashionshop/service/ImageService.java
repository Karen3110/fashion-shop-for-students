package com.fshop.fashionshop.service;

import com.fshop.fashionshop.model.Product;
import com.fshop.fashionshop.model.commons.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {


    Product saveImagesToFolder(long productId, MultipartFile[] images, String imageMappingPath);

    byte[] readByFolderNameAndImageName(String folderName, String imageName) throws IOException;

    Image update(MultipartFile file);

    void delete(MultipartFile file);


}
