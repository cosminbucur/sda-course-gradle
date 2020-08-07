package com.bucur.spring.thymeleaf.repository;

import com.bucur.spring.thymeleaf.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
