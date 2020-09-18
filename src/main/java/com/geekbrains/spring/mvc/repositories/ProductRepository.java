package com.geekbrains.spring.mvc.repositories;

import com.geekbrains.spring.mvc.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Apple", 15));
        products.add(new Product(2L, "Water", 18));
        products.add(new Product(3L, "Lemon", 25));
        products.add(new Product(4L, "Tea", 22));
    }

    public List<Product> getAAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public void save(Product product) {
        products.add(product);
    }


    public void deleteById(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    public Product findById(Long id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        throw new RuntimeException("Product not found");
    }

 }
