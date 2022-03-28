package com.fshop.fashionshop.service.impl;

import com.fshop.fashionshop.model.Product;
import com.fshop.fashionshop.model.commons.Image;
import com.fshop.fashionshop.service.ImageService;
import com.fshop.fashionshop.util.FileDatasource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {


    @Override
    public Product saveImagesToFolder(Product product, MultipartFile[] images) {

        FileDatasource fileDatasource = new FileDatasource();
        String productFolder = fileDatasource.createProductFolder(generateFolderName(product));


        for (MultipartFile image : images) {
            String fileName = StringUtils.cleanPath(image.getOriginalFilename());

            Path uploadDirectory = Paths.get(productFolder);

            System.out.println("fileName\t"+ productFolder+'/'+fileName);

//
//            try (InputStream inputStream = image.getInputStream()){
//                Path filePath = uploadDirectory.resolve(fileName);
//
//                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
//            } catch (IOException e) {
//                try {
//                    throw new IOException(" Error saving upload file" + fileName, e);
//                } catch (IOException ioException) {
//                    ioException.printStackTrace();
//                }
//            }
        }

        return product;
    }

    @Override
    public Image read(MultipartFile file) {
        return null;
    }

    @Override
    public Image update(MultipartFile file) {
        return null;
    }

    @Override
    public void delete(MultipartFile file) {

    }


    private String generateFolderName(Product product){
        return product.getName()+"_"+product.getId();
    }
}
