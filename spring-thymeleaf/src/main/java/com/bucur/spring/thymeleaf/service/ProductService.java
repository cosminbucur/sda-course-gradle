package com.bucur.spring.thymeleaf.service;

import com.bucur.spring.thymeleaf.exception.NotFoundException;
import com.bucur.spring.thymeleaf.model.Product;
import com.bucur.spring.thymeleaf.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        log.debug("finding all products");
        return productRepository.findAll();
    }

    public Product findById(long id) {
        log.debug("finding product by id: {}", id);
        return productRepository.findById(id).orElseThrow(() ->
                new NotFoundException("product not found"));
    }

    @Transactional
    public Product save(Product createProductRequest) {
        log.debug("saving product: {}", createProductRequest);
        return productRepository.save(createProductRequest);
    }

    @Transactional
    public Product update(Product updateRequest, long id) {
        log.debug("updating product with id: {} and request body: {}", id, updateRequest);
        Product productToUpdate = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found"));

        return productRepository.save(productToUpdate);
    }

    @Transactional
    public void delete(long id) {
        log.debug("deleting product with id: {}", id);
        productRepository.deleteById(id);
    }
}
