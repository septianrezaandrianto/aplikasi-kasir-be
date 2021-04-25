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
import org.springframework.web.bind.annotation.RestController;

import com.application.aplikasikasir.Constant;
import com.application.aplikasikasir.dtos.OrderDTO;
import com.application.aplikasikasir.models.Order;
import com.application.aplikasikasir.models.customs.OrderProduct;
import com.application.aplikasikasir.repositories.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;



@CrossOrigin(origins ="*", allowedHeaders = "*")
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	
	private Order convertDtoToEntity(OrderDTO orderDto) {
		return modelMapper.map(orderDto, Order.class);
	}
	
	private OrderDTO convertEntityToDto(Order order) {
		return modelMapper.map(order, OrderDTO.class);
	}
	
	@GetMapping("/readAll")
	public Map<String, Object> readAllOrder() {
		Map<String, Object> result = new HashMap<>();
		List<Order> orders = orderRepository.findAll();
		List<OrderDTO> listData = new ArrayList<>();
		String message = null;
		
		for (Order order : orders) {
			listData.add(convertEntityToDto(order));
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
	
	
	@PostMapping("/create")
	public Map<String, Object> createOrder(@RequestBody OrderProduct orderProduct) throws JsonMappingException, JsonProcessingException {
		Map<String, Object> result = new HashMap<>();
	
		Gson gson = new Gson();
		String object = gson.toJson(orderProduct.getOrderProduct());
		
		Order input = new Order();
		
		input.setTotal(orderProduct.getTotal());
		input.setOrderProduct(object);
			
		Order inputResult = orderRepository.save(input);		
		
		result.put(Constant.RESPONSE_STRING, HttpStatus.OK);
		result.put(Constant.MESSAGE_STRING, Constant.SUCCESS_STRING);
		result.put(Constant.DATA_STRING, inputResult);
		
		return result;
	}
	
}


