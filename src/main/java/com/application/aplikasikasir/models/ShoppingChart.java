package com.application.aplikasikasir.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="shopping_chart", schema = "public")
public class ShoppingChart implements Serializable {

	private static final long serialVersionUID = 1L;
	
//	CREATE SEQUENCE IF NOT EXISTS shopping_chart_id_seq
//	INCREMENT BY 1
//	MINVALUE 1
//	MAXVALUE 987654321
//	START WITH 1
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_shopping_chart_id_seq")
	@SequenceGenerator(name="generator_shopping_chart_id_seq", sequenceName = "shopping_chart_id_seq", schema = "public", allocationSize = 1)
	@Column(name="shopping_chart_id", unique = true, nullable = false)
	private Long shoppingChartId;
	
	@Column(name="total")
	private Integer total;
	
	@Column(name="price")
	private BigDecimal price;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
	
//	@Column(name="note")
//	private String note;
}
