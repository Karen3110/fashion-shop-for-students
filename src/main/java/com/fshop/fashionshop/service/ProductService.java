package com.fshop.fashionshop.service;

import com.fshop.fashionshop.model.Product;
import org.springframework.web.server.ResponseStatusException;

public interface ProductService {

    Product getByID(long id) ;

}
