package com.probal.jpatest.service;

import com.probal.jpatest.dto.ProductRequest;
import com.probal.jpatest.model.Product;
import com.probal.jpatest.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductRequest saveProduct(ProductRequest productRequest) {
        Product product = productRepository.save(ProductRequest.to(productRequest));
        return ProductRequest.from(product);
    }

    public ProductRequest updateProduct(Long id, ProductRequest productRequest) throws Exception {
        Product product = productRepository.findById(id).orElseThrow(Exception::new);
        Product updatedProduct = productRepository.save(ProductRequest.update(product, productRequest));
        return ProductRequest.from(updatedProduct);
    }

    public ProductRequest getProduct(Long id) throws Exception {
        Product product = productRepository.findById(id).orElseThrow(Exception::new);
        return ProductRequest.from(product);
    }

    public List<ProductRequest> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductRequest::from)
                .collect(Collectors.toList());
    }

    public List<ProductRequest> getDeletedProducts() {
        return productRepository.recycleBin()
                .stream()
                .map(ProductRequest::from)
                .collect(Collectors.toList());
    }



    @Transactional
    public void deleteProduct(Long id) throws Exception {
        productRepository.softDelete(id);
    }

}
