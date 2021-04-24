package com.application.aplikasikasir.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.aplikasikasir.Constant;
import com.application.aplikasikasir.dtos.CategoryDTO;
import com.application.aplikasikasir.models.Category;
import com.application.aplikasikasir.repositories.CategoryRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	ModelMapper modelMapper = new ModelMapper();
	
	private Category convertDtoToEntity(CategoryDTO categoryDto) {
		return modelMapper.map(categoryDto, Category.class);
	}
	
	private CategoryDTO convertEntityToDto(Category category) {
		return modelMapper.map(category, CategoryDTO.class);
	}
	
	@GetMapping("/readAll")
	public Map<String, Object> readCategoryList() {
		Map<String, Object> result = new HashMap<>();
		List<CategoryDTO> listData = new ArrayList<>();
		
		for (Category category : categoryRepository.findAll()) {
			listData.add(convertEntityToDto(category));
		}
		
		result.put(Constant.RESPONSE_STRING, HttpStatus.OK);
		result.put(Constant.MESSAGE_STRING, Constant.SUCCESS_STRING);
		result.put(Constant.DATA_STRING, listData);
		result.put(Constant.TOTAL_STRING, listData.size());
		
		return result;
	}
	
	@PostMapping("/create")
	public Map<String, Object> createCategory(@RequestBody CategoryDTO categoryDto) {
		Map<String, Object> result = new HashMap<>();
		
		Category input = new Category();
		Category category = convertDtoToEntity(categoryDto);
		
		
		input.setCategoryName(category.getCategoryName());
		input.setCreatedBy(category.getCreatedBy());
		input.setLastModifiedBy(category.getLastModifiedBy());
		input.setIsDeleted(false);
		
		Category resultInput = categoryRepository.save(input);
		
		result.put(Constant.RESPONSE_STRING, HttpStatus.OK);
		result.put(Constant.MESSAGE_STRING, Constant.SUCCESS_STRING);
		result.put(Constant.DATA_STRING, resultInput);
		
		return result;
	}
	
}
