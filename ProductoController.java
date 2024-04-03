package com.example.demo.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductoDTO;
import com.example.demo.model.Producto;
import com.example.demo.repository.IProductoRepository;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {
	IProductoRepository repoProducto;
	
	public ProductoController(IProductoRepository repoProducto) {
		this.repoProducto = repoProducto;
	}
	
	@PostMapping
	public ResponseEntity<Void>  alta(@RequestBody ProductoDTO prod) {
		Producto producto = new Producto();
		producto.setId(UUID.randomUUID().toString());
		producto.setCosto(prod.getCosto());
		producto.setNombre(prod.getNombre());
		producto.setStock(prod.getStock());
		repoProducto.save(producto);
		return ResponseEntity.ok().build();
	}
	
	
	@GetMapping
	public ResponseEntity<List<ProductoDTO>>  getProductos() {
		
		List<ProductoDTO> productos =repoProducto.findAll()
		.stream()
		.map( domain-> 
		new ProductoDTO(domain.getNombre(),
				domain.getCosto(),domain.getStock())).collect(Collectors.toList());
		return ResponseEntity.ok(productos);
	}
	
	@DeleteMapping
	public ResponseEntity<Void>  deleteProducto(@RequestParam String id) {
		Producto producto = new Producto();
		producto.setId(id);
		repoProducto.delete(producto);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void>  updateproducto(String id,@RequestBody ProductoDTO prod) {
		Producto producto = new Producto();
		producto.setId(id);
		producto.setCosto(prod.getCosto());
		producto.setNombre(prod.getNombre());
		producto.setStock(prod.getStock());
		repoProducto.save(producto);
		return ResponseEntity.ok().build();
	}
	
	
	
}
