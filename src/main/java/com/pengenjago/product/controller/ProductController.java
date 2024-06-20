package com.pengenjago.product.controller;

import com.pengenjago.product.helpers.dto.ProductReqDto;
import com.pengenjago.product.helpers.dto.ResponseApiDto;
import com.pengenjago.product.models.entity.Product;
import com.pengenjago.product.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController extends BaseController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping
    public ResponseEntity<ResponseApiDto> getAllProducts() {
        List<Product> list = productService.getAllProducts();

        return new ResponseEntity<>(ResponseOk(list), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseApiDto> getProductById(@PathVariable int id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>(ResponseNotFound("Product with id " + id + " not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ResponseOk(product), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ResponseApiDto> addProduct(@RequestBody ProductReqDto productReq) {

        return new ResponseEntity<>(ResponseOk(productService.createProduct(productReq)),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseApiDto> updateProduct(@RequestBody Product product, @PathVariable long id) {
        Product check = productService.getProductById(id);
        if (check == null) {
            return new ResponseEntity<>(ResponseNotFound("Product with id " + id + " not found"), HttpStatus.NOT_FOUND);
        }

        product.setId(id);

        return new ResponseEntity<>(ResponseOk(productService.updateProduct(product)),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseApiDto> deleteProduct(@PathVariable int id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>(ResponseNotFound("Product with id " + id + " not found"), HttpStatus.NOT_FOUND);
        }

        productService.deleteProductById(id);

        return new ResponseEntity<>(ResponseOk(null), HttpStatus.OK);
    }
}
