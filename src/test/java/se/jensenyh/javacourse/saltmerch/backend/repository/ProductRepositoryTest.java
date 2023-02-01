package se.jensenyh.javacourse.saltmerch.backend.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

class ProductRepositoryTest {
 @SpringBootTest
  public class productRepositoryTest {
    @Autowired
    private ProductRepository db;
    @Test
     void selectAll()
     {   List<String> product = Arrays.asList("Clothes", "Socks", "Unisex ", "Out of stock ");
         List<String> product2 = Arrays.asList("Clothes", "Socks", "Unisex ", "Out of stock");

         Assertions.assertIterableEquals(product, product2);}
}
    @Test
    void selectAll() {
    }

    @Test
    void getEntireProduct() {
    }
}