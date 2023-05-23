package com.telusko.ProductSpringWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController {

  @Autowired
  ProductService service;

  @GetMapping("/products")
  public List<Product> getAllProducts() {
    return service.getAllProducts();
  }

  @GetMapping("/product/{name}")
  public Product getProduct(@PathVariable String name) {
    return service.getProduct(name);
  }

  @PostMapping("/product")
  public void addProduct(@RequestBody Product product) {
    service.addProduct(product);
  }

  @GetMapping("/outOfWarrantyProducts")
  public List<Product> getOutOfWarrantyProducts() {
    return service.getOutOfWarrantyProducts();
  }

  @GetMapping("/product/place/{place}")
  public List<Product> getProductsByPlace(@PathVariable String place) {
    return service.getProductByPlace(place);
  }

  @GetMapping("/product/text/{text}")
  public List<Product> getProductsByText(@PathVariable String text) {
    return service.getProductWithText(text);
  }
}
