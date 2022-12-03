package com.probal.jpatest.controller;

import com.probal.jpatest.dto.ProductRequest;
import com.probal.jpatest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get/{id}")
    public ProductRequest getProduct(@PathVariable Long id) throws Exception {
        return productService.getProduct(id);
    }

    @GetMapping("/get/all")
    public List<ProductRequest> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/recycle_bin")
    public List<ProductRequest> getDeletedProducts() {
        return productService.getDeletedProducts();
    }

    @PostMapping("/add")
    public ProductRequest addProduct(@RequestBody ProductRequest productRequest) {
        return productService.saveProduct(productRequest);
    }

    @PutMapping("/update/{id}")
    public ProductRequest updateProduct(@RequestBody ProductRequest productRequest,
                                        @PathVariable Long id) throws Exception {
        return productService.updateProduct(id, productRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) throws Exception {
        productService.deleteProduct(id);
    }
}
