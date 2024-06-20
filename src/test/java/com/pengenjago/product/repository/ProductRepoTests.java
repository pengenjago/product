package com.pengenjago.product.repository;

import com.pengenjago.product.models.entity.Product;
import com.pengenjago.product.models.repository.ProductRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ProductRepoTests {
    @Autowired
    private ProductRepo productRepo;

    @Test
    public void Test_CreateProductRepo() {
        Product product = Product.builder().
                name("TWS Soundcore").
                price(350000).build();

        Product created = productRepo.save(product);

        Assertions.assertNotNull(created);
        Assertions.assertTrue(created.getId() > 0);
    }

    @Test
    public void Test_FindAllProductRepo() {
        Product product = Product.builder().
                name("TWS Soundcore").
                price(350000).build();

        Product product2 = Product.builder().
                name("Mouse Logitect").
                price(350000).build();

        productRepo.save(product);
        productRepo.save(product2);

        List<Product> productList = productRepo.findAll();

        Assertions.assertNotNull(productList);
        Assertions.assertTrue(productList.size() >= 2);
    }

    @Test
    public void Test_FindByIdProductRepo() {
        Product product = Product.builder().
                name("TWS Soundcore").
                price(350000).build();
        productRepo.save(product);

        Product checkProduct = productRepo.findById(product.getId()).orElse(null);

        Assertions.assertNotNull(checkProduct);
        Assertions.assertEquals(product.getName(), checkProduct.getName());
    }

    @Test
    public void Test_UpdateProductRepo() {
        Product product = Product.builder().
                name("TWS Soundcore").
                price(350000).build();
        productRepo.save(product);

        product.setName("TWS Soundcore2");
        Product updatedProduct = productRepo.save(product);

        Assertions.assertNotNull(product);
        Assertions.assertEquals(product.getName(), updatedProduct.getName());
    }
}
