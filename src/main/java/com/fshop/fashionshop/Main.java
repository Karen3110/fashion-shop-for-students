package com.fshop.fashionshop;

import com.fshop.fashionshop.model.Order;
import com.fshop.fashionshop.model.Product;
import com.fshop.fashionshop.model.User;
import com.fshop.fashionshop.repository.ProductRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class Main {


    public static void main(String[] args) {

        Order order = new Order();
        order.setUser(new User());
        order.setProduct(new Product());

        System.out.println(new Gson().toJson(order));


    }
}
