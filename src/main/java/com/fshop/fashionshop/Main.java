package com.fshop.fashionshop;

import com.fshop.fashionshop.model.Order;
import com.fshop.fashionshop.model.Product;
import com.fshop.fashionshop.model.User;
import com.fshop.fashionshop.repository.ProductRepository;
import com.fshop.fashionshop.util.FileDatasource;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;


public class Main {


    public static void main(String[] args) {

        FileDatasource fileDatasource = new FileDatasource();

        fileDatasource.createProductFolder("product_1");
        fileDatasource.createProductFolder("product_2");
        fileDatasource.createProductFolder("product_2");
        fileDatasource.createProductFolder("product_3");




    }
}
