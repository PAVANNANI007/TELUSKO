package com.telusko.ProductSpring;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDB extends JpaRepository<Product, Integer> {
  Product findByName(String name);

  @Query("SELECT p FROM Product p WHERE p.warranty<YEAR(CURRENT_DATE)")
  java.util.List<Product> findproductsoutofWarranty();

  @Query("SELECT p FROM Product p WHERE LOWER(p.place) LIKE %:place%")
  java.util.List<Product> findbyplace(String place);

  @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE %:text% OR LOWER(p.type) LIKE %:text% OR LOWER(p.place) LIKE %:text%")
  java.util.List<Product> findByText(String text);

}
