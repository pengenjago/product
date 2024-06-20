package com.pengenjago.product.models.repository;

import com.pengenjago.product.models.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {


}
