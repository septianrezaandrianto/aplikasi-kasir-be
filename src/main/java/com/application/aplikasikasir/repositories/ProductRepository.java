package com.application.aplikasikasir.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.aplikasikasir.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
