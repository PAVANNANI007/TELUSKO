package com.telusko.ProductSpringWeb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDB extends JpaRepository<Product, Integer> {

  Product findByName(String name);

  List<Product> findByNameContainingIgnoreCaseOrTypeContainingIgnoreCaseOrPlaceContainingIgnoreCase(String text,
      String text2, String text3);

  List<Product> findByPlaceIgnoreCase(String place);

  List<Product> findByWarrantyLessThan(int year);

}
