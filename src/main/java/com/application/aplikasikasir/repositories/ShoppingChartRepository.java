package com.application.aplikasikasir.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.application.aplikasikasir.models.ShoppingChart;

@Repository
public interface ShoppingChartRepository extends JpaRepository<ShoppingChart, Long> {

	@Query(value= "SELECT * FROM shopping_chart sc "
			+ "WHERE sc.product_id = :productId", nativeQuery = true)
	public ShoppingChart findByProductId (@Param("productId") Long productId); 
	
}
