package com.example.shopapi.repositories;

import com.example.shopapi.entities.Product;
import com.example.shopapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
