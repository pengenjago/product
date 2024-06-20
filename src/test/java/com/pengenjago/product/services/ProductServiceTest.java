package com.pengenjago.product.services;

import com.pengenjago.product.helpers.dto.ProductReqDto;
import com.pengenjago.product.models.entity.Product;
import com.pengenjago.product.models.repository.ProductRepo;
import com.pengenjago.product.services.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepo productRepo;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void Test_CreateProductService() {
        Product product = Product.builder().
                name("TWS Soundcore").
                price(350000).build();

        ProductReqDto productReq = ProductReqDto.builder().
                name("TWS Soundcore").
                price(350000).build();

        when(productRepo.save(Mockito.any(Product.class))).thenReturn(product);

        Product createdProduct = productService.createProduct(productReq);

        Assertions.assertNotNull(createdProduct);
    }
}
