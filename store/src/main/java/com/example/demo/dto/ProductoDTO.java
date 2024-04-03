package com.example.demo.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;


public class ProductoDTO {
	private String nombre;
	private BigDecimal costo;
	private Integer stock;
	
	public ProductoDTO() {
	
	}
	public ProductoDTO(String nombre, BigDecimal costo, Integer stock) {
		super();
		this.nombre = nombre;
		this.costo = costo;
		this.stock = stock;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getCosto() {
		return costo;
	}
	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}

}
