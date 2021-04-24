package com.application.aplikasikasir.dtos;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {

	private Long productId;
	private String productName;
	private String productPhoto;
	private String productCode;
	private BigDecimal productPrice;
	private CategoryDTO category;
	private String createdBy;
	private Date createdOn;
	private String lastModifiedBy;
	private Date lastModifiedOn;
	private Boolean isDeleted;
	
}
