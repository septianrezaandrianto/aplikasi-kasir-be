package com.application.aplikasikasir.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="orders", schema = "public")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
//	CREATE SEQUENCE IF NOT EXISTS order_id_seq
//	INCREMENT BY 1
//	MINVALUE 1
//	MAXVALUE 987654321
//	START WITH 1
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="generator_order_id_seq")
	@SequenceGenerator(name="generator_order_id_seq", sequenceName="order_id_seq", schema="public", allocationSize = 1)
	@Column(name ="order_id", unique= true, nullable = false)
	private Long orderId;
	
	@Column(name="total")
	private BigDecimal total;
	
	@Column(name="order_product")
	private String orderProduct;
	
}
