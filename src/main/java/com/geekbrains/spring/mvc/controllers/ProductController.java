package com.geekbrains.spring.mvc.controllers;

import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService){ this.productService = productService;}

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("frontProducts", productService.getAllProducts());
        return "product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, Model model) {
        productService.deleteById(id);
        List<Product> list = productService.getAllProducts();
        model.addAttribute("products", list);
        return "redirect:/products/all";
    }

    @PostMapping("/add")
    public String addNewProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products/all";
    }


    @GetMapping("/find_product/{id}")
    public String showFindProductById(@PathVariable Long id, Model model) {
        List<Product> list = new ArrayList<>();
        list.add(productService.findById(id));
        model.addAttribute("frontProducts", list);
        return "product";

    }

    @PostMapping("/json/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewJsonProduct(@RequestBody Product product) {
        productService.save(product);
    }

    @GetMapping("/json/{id}")
    @ResponseBody
    public Product showJsonProduct(@PathVariable Long id) {
        return productService.findById(id);
    }

}
