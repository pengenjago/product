package com.pengenjago.product.services.impl;

import com.pengenjago.product.helpers.dto.ProductReqDto;
import com.pengenjago.product.models.entity.Product;
import com.pengenjago.product.models.repository.ProductRepo;
import com.pengenjago.product.services.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        List<Product> products = productRepo.findAll();

        return products.stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
    };

    public Product createProduct(ProductReqDto productReq) {

        Product product = new Product();
        product.setName(productReq.getName());
        product.setPrice(productReq.getPrice());
        product.setDescriptions(productReq.getDescriptions());
        product.setProductionDate(productReq.getProductionDate());

        Product  product2 = Product.builder().
                name(productReq.getName()).
                price(productReq.getPrice()).
                descriptions(productReq.getDescriptions()).build();

        productRepo.save(product2);

        return productRepo.save(product);
    }

    public Product getProductById(long id) {
        Optional<Product> product = productRepo.findById(id);

        return product.orElse(null);
    }

    public void deleteProductById(long id) {
        productRepo.deleteById(id);
    }

    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }
}
