package com.application.aplikasikasir.models.customs;

import java.math.BigDecimal;
import java.util.List;

import com.application.aplikasikasir.models.ShoppingChart;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderProduct {

	private BigDecimal total;
	private List<ShoppingChart> orderProduct;
}
