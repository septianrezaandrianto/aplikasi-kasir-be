package com.application.aplikasikasir.dtos;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShoppingChartDTO {

	private Long shoppingChartId;
	private Integer total;
	private BigDecimal price;
	private ProductDTO product;
	
}
