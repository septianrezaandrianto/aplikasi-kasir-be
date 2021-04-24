package com.application.aplikasikasir.dtos;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDTO {

	private Long categoryId;
	private String categoryName;
	private Long createdBy;
	private Date createdOn;
	private Long lastModifiedBy;
	private Date lastModifiedOn;
	private Boolean isDeleted;
}
