package com.application.aplikasikasir.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.aplikasikasir.Constant;
import com.application.aplikasikasir.dtos.ShoppingChartDTO;
import com.application.aplikasikasir.models.ShoppingChart;
import com.application.aplikasikasir.repositories.ShoppingChartRepository;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/shoppingChart")
public class ShoppingChartController {

	@Autowired
	private ShoppingChartRepository shoppingChartRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	private ShoppingChart convertDtoToEntity(ShoppingChartDTO shoppingChartDTO) {
		return modelMapper.map(shoppingChartDTO, ShoppingChart.class);
	}
	
	private ShoppingChartDTO convertEntityToDto(ShoppingChart shoppingChart) {
		return modelMapper.map(shoppingChart, ShoppingChartDTO.class);
	}
	
	
	@GetMapping("/readAll")
	public Map<String, Object> readAllShoppingChart() {
		Map<String, Object> result = new HashMap<>();
		List<ShoppingChartDTO> listData = new ArrayList<>();
		String message = null;
		
		for (ShoppingChart shoppingChart : shoppingChartRepository.findAll()) {
			listData.add(convertEntityToDto(shoppingChart));
		}
		
		if (!listData.isEmpty()) {
			message = Constant.SUCCESS_STRING;
		}
		else {
			message = Constant.EMPTY_DATA_STRING;
		}
		
		result.put(Constant.RESPONSE_STRING, HttpStatus.OK);
		result.put(Constant.MESSAGE_STRING, message);
		result.put(Constant.DATA_STRING, listData);
		result.put(Constant.TOTAL_STRING, listData.size());
		
		return result;
	}
	
	
	@GetMapping("/read")
	public Map<String, Object> readByProductId(@RequestParam("productId") Long productId) {
		Map<String, Object> result = new HashMap<>();
		String message = null;
		ShoppingChartDTO shoppingChartDto = null;
		
		ShoppingChart shoppingChart = shoppingChartRepository.findByProductId(productId);
		
		if (shoppingChart != null) {
			message = Constant.SUCCESS_STRING;
			shoppingChartDto = convertEntityToDto(shoppingChart);
			
		}
		else {
			message = Constant.EMPTY_DATA_STRING;
		}
		
		result.put(Constant.RESPONSE_STRING, HttpStatus.OK);
		result.put(Constant.MESSAGE_STRING, message);
		result.put(Constant.DATA_STRING, shoppingChartDto);
		
		return result;
	}
	
	
	@PostMapping("/create")
	public Map<String, Object> createShoppingChart(@RequestBody ShoppingChartDTO shoppingChartDTO) {
		Map<String, Object> result = new HashMap<>();
		ShoppingChart input = new ShoppingChart();		
		ShoppingChart shoppingChart = convertDtoToEntity(shoppingChartDTO);
		
		input.setPrice(shoppingChart.getPrice());
		input.setTotal(shoppingChart.getTotal());
		input.setProduct(shoppingChart.getProduct());
//		input.setNote("");
		
		ShoppingChart resultInput = shoppingChartRepository.save(input);
		
		result.put(Constant.RESPONSE_STRING, HttpStatus.OK);
		result.put(Constant.MESSAGE_STRING, Constant.SUCCESS_STRING);
		result.put(Constant.DATA_STRING, resultInput);
		
		return result;
	}
	

	@PutMapping("/update/{shoppingChartId}")
	public Map<String, Object> updateShoppingChart(@PathVariable(name="shoppingChartId") Long id, @RequestBody ShoppingChartDTO shoppingChartDto) {
		Map<String, Object> result = new HashMap<>();
		ShoppingChart input = shoppingChartRepository.findById(id).orElse(null);
		ShoppingChart shoppingChart = convertDtoToEntity(shoppingChartDto);
		
		if (shoppingChart.getTotal() == null) {
			input.setTotal(input.getTotal());
		}
		else {
			input.setTotal(shoppingChartDto.getTotal());
		}
		
		if (shoppingChart.getPrice() == null) {
			input.setPrice(input.getPrice());
		}
		else {
			input.setPrice(shoppingChart.getPrice());
		}
		
		if (shoppingChart.getProduct() == null) {
			input.setProduct(input.getProduct());
		}
		else {
			input.setProduct(shoppingChart.getProduct());
		}
		
		ShoppingChart resultInput = shoppingChartRepository.save(input);
		
		result.put(Constant.RESPONSE_STRING, HttpStatus.OK);
		result.put(Constant.MESSAGE_STRING, Constant.SUCCESS_STRING);
		result.put(Constant.DATA_STRING, resultInput);
		
		return result;
	}
	
	
	@DeleteMapping("/delete")
	public Map<String, Object> deleteShoppingChart(@RequestParam("shoppingChartId") Long shoppingChartId) {
		Map<String, Object> result = new HashMap<>();
		ShoppingChart shoppingChart = shoppingChartRepository.findById(shoppingChartId).orElse(null);
		
		shoppingChartRepository.delete(shoppingChart);
		
		result.put(Constant.RESPONSE_STRING, HttpStatus.OK);
		result.put(Constant.MESSAGE_STRING, Constant.SUCCESS_STRING);
		result.put(Constant.DATA_STRING, shoppingChart);
		
		return result;
	}
}
