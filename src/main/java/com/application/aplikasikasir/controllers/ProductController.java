package com.application.aplikasikasir.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.aplikasikasir.Constant;
import com.application.aplikasikasir.dtos.ProductDTO;
import com.application.aplikasikasir.models.Product;
import com.application.aplikasikasir.repositories.ProductRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository ProductRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	private Product convertDtoToEntity(ProductDTO productDto) {
		return modelMapper.map(productDto, Product.class);
	}
	
	private ProductDTO convertEntityToDto(Product product) {
		return modelMapper.map(product, ProductDTO.class);
	}
	
	@GetMapping("/readAll")
	public Map<String, Object> readProductList(@RequestParam Long categoryId) {
		Map<String, Object> result = new HashMap<>();
		List<ProductDTO> listData = new ArrayList<>();		
		String message = null;
		
		for (Product product : ProductRepository.findAll()) {
			if (product.getCategory().getCategoryId() != null && categoryId == product.getCategory().getCategoryId()) {
				listData.add(convertEntityToDto(product));
				message = Constant.SUCCESS_STRING;
			}
			else {
				message = Constant.EMPTY_DATA_STRING;
			}
		}
		
		result.put(Constant.RESPONSE_STRING, HttpStatus.OK);
		result.put(Constant.MESSAGE_STRING, message);
		result.put(Constant.DATA_STRING, listData);
		result.put(Constant.TOTAL_STRING, listData.size());
		
		return result;
	}
	
	
	@PostMapping("/create")
	public Map<String, Object> createProduct(@RequestBody ProductDTO productDto) {
		Map<String, Object> result = new HashMap<>();
		
		Product input = new Product();
		Product product = convertDtoToEntity(productDto);
		
		input.setProductName(product.getProductName());
		input.setProductPrice(product.getProductPrice());
		input.setProductPhoto(product.getProductPhoto());
		input.setCreatedBy(product.getCreatedBy());
		input.setLastModifiedBy(product.getLastModifiedBy());
		input.setCategory(product.getCategory());
		input.setProductCode(product.getProductCode());
		input.setIsDeleted(false);
		
		Product resultInput = ProductRepository.save(input);
		
		result.put(Constant.RESPONSE_STRING, HttpStatus.OK);
		result.put(Constant.MESSAGE_STRING, Constant.SUCCESS_STRING);
		result.put(Constant.DATA_STRING, resultInput);
		
		return result;
		
	}
	
}
