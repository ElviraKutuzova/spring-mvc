package com.geekbrains.spring.mvc.services;

import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    private ProductRepository productRepository;

        @Autowired
        public void setProductRepository(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }

        public List<Product> getAllProducts() {
            return productRepository.getAAllProducts();
        }

        public void save(Product product) {
            productRepository.save(product);
        }

        public void deleteById(Long id) {
            productRepository.deleteById(id);
        }

    public Product findById(Long id) {
        return productRepository.findById(id);
    }


}
