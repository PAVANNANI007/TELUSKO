package com.telusko.ProductSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

  @Autowired
  ProductDB db;

  // public void addProduct(Product p){
  //// products.add(p);
  //
  // db.save(p);
  //
  // }
  //
  public List<Product> getAllProducts() {

    return db.findAll();
  }

  public Product getProductbyname(String name) {

    return db.findByName(name);
  }

  public List<Product> getProductbytext(String text) {
    String str = text.toLowerCase();
    return db.findByText(str);
  }

  public List<Product> getProductsoutofWarranty() {

    return db.findproductsoutofWarranty();
  }

  public List<Product> getAbyPlace(String place) {

    return db.findbyplace(place.toLowerCase());
  }

  // 1.product with text
  // 2.product out of warranty
  // 3.products by place

  //
  // public Product getProduct(String name){
  // for(Product p : products){
  // if(p.getName().equals(name))
  // return p;
  // }
  //
  // return null;
  // }

}
