package com.sha.springbootproductseller.repository;

import com.sha.springbootproductseller.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sa
 * @date 18.12.2021
 * @time 12:10
 */
public interface ProductRepository extends JpaRepository<Product, Long>
{
    // JpaRepository is an Abstract Class
    // With JpaRepository, Spring handles basic CRUD db operations
    // (ex. findAll, findAllById, saveAll, etc.)

    // also, automatically generates queries based on method names
}
