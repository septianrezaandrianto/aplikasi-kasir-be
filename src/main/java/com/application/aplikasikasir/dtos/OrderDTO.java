package com.application.aplikasikasir.dtos;

import java.math.BigDecimal;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDTO {

	private Long orderId;
	private BigDecimal total;
	private String orderProduct;
	
}
