package se.jensenyh.javacourse.saltmerch.backend.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3010")
@RequestMapping("/api/v1")
public class ProductController
{
    @Autowired
    ProductRepository productRepository;
    @GetMapping("/products")
        public List<Product> getAllProducts() {
        return productRepository.selectAll();
    }
    @GetMapping("/products/hats")
     public List<Product>getAllHats(){
        return productRepository.selectAllOfCategory("hats");

    }
    @GetMapping("/products/tshirts")
    public List<Product>getAllTshirts()
    {
        return productRepository.selectAllOfCategory("tshirts");
    }
    @GetMapping("/products/jackets")
    public List<Product>getAllJackets()
    {
        return productRepository.selectAllOfCategory("jackets");
    }
    @GetMapping("/products/bags")
    public List<Product>getAllBags()
    {
        return productRepository.selectAllOfCategory("bags");
    }
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") int id)
    {
        return productRepository.getEntireProduct(id);
    }
}