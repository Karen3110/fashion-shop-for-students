package com.fshop.fashionshop.repository;

import com.fshop.fashionshop.model.Product;
import com.fshop.fashionshop.model.commons.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
