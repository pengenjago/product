package com.pengenjago.product.services;

import com.pengenjago.product.helpers.dto.ProductReqDto;
import com.pengenjago.product.models.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product createProduct(ProductReqDto productReq);
    Product updateProduct(Product product);
    void deleteProductById(long id);
}
