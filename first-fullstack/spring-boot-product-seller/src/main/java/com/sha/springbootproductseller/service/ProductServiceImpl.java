package com.sha.springbootproductseller.service;

import com.sha.springbootproductseller.model.Product;
import com.sha.springbootproductseller.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author sa
 * @date 18.12.2021
 * @time 12:31
 */
@Service
public class ProductServiceImpl implements ProductService
{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    // service layer interacts with repository layer...
    // since it doesn't extend JpaRepository, need to define
    // ALSO
    // adding @Override, so we can encapsulate && access via interface
    @Override
    public Product saveProduct(Product product)
    {
        product.setCreateTime(LocalDateTime.now());

        return productRepository.save(product); // easy - call JpaRepository
    }

    @Override
    public void deleteProduct(Long id)
    {
        productRepository.deleteById(id); // easy - call JpaRepository
    }

    @Override
    public List<Product> findAllProducts()
    {
        return productRepository.findAll();
    }
}
