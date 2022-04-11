package com.fshop.fashionshop;

import com.fshop.fashionshop.model.Order;
import com.fshop.fashionshop.model.Product;
import com.fshop.fashionshop.model.User;
import com.fshop.fashionshop.repository.ProductRepository;
import com.fshop.fashionshop.util.FileConstants;
import com.fshop.fashionshop.util.FileDatasource;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ContextPathCompositeHandler;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;


public class Main {


    public static void main(String[] args) {


//        FileDatasource fileDatasource=new FileDatasource();
//        Product product = new Product();
//        product.setId(1L);
//        product.setName("fanta");
//        System.out.println(fileDatasource.getFolderPathByProduct(product));

        File file = new File(new File("").getAbsolutePath()+File.separator+ FileConstants.DATA_FOLDER_NAME+"/Fanta_1");

        for (File item : file.listFiles()) {
            System.out.println(item.getAbsolutePath());
        }

    }
}
