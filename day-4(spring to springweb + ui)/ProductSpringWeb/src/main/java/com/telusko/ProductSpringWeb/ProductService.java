package com.telusko.ProductSpringWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  @Autowired
  ProductDB db;

  public void addProduct(Product p) {
    db.save(p);
  }

  public List<Product> getAllProducts() {
    return db.findAll();
  }

  public Product getProduct(String name) {
    return db.findByName(name);
  }

  public List<Product> getProductWithText(String text) {
    return db.findByNameContainingIgnoreCaseOrTypeContainingIgnoreCaseOrPlaceContainingIgnoreCase(text, text, text);
  }

  public List<Product> getProductByPlace(String text) {
    return db.findByPlaceIgnoreCase(text);
  }

  public List<Product> getOutOfWarrantyProducts() {
    return db.findByWarrantyLessThan(2023);
  }
}
