package com.postgreSQL.ProductManagement.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postgreSQL.ProductManagement.Service.ProductService;
import com.postgreSQL.ProductManagement.models.Product;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping("{id}")
	public ResponseEntity<Product> updateProductsPlace(@PathVariable int id) {

		try {
			return new ResponseEntity<>(service.getProductById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new Product(), HttpStatus.BAD_REQUEST);
		}

	} 

	@GetMapping("allProducts")
	public ResponseEntity<List<Product>> getAllProducts() {

		try {
			return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("save")
	public ResponseEntity<String> addProduct(@RequestBody Product product) {

		try {
			service.addProducts(product);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed Creating new Product", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>("Created", HttpStatus.CREATED);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {

		try {
			service.deleteProduct(id);
		} catch (Exception e) {
			return new ResponseEntity<>("Product with the ID not found", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	}

	@GetMapping("place/{place}")
	public ResponseEntity<List<Product>> getProductsByPlace(@PathVariable String place) {

		try {
			return new ResponseEntity<>(service.getProductsByPlace(place), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
		}

	}
	
	@GetMapping("type/{type}")
	public ResponseEntity<List<Product>> getProductsByType(@PathVariable String type) {

		try {
			return new ResponseEntity<>(service.getProductsByType(type), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("expire/{year}")
	public ResponseEntity<List<Product>> getExpiredProducts(@PathVariable int year) {

		try {
			return new ResponseEntity<>(service.getExpiredProducts(year), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
		}

	}
	
	@GetMapping("keyword/{keyword}")
	public ResponseEntity<List<Product>> getProductsByKeyword(@PathVariable String keyword) {

		try {
			return new ResponseEntity<>(service.getProductsByKeyword(keyword), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
		}

	}
	
	@PatchMapping("place/{id}/{newPlace}")
	public ResponseEntity<Product> updateProductsPlace(@PathVariable int id, @PathVariable String newPlace) {

		try {
			return new ResponseEntity<>(service.updateProductsPlace(id, newPlace), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new Product(), HttpStatus.BAD_REQUEST);
		}

	}
	
	@DeleteMapping("delete/name/{name}")
	public ResponseEntity<String> deleteProductByName(@PathVariable String name) {

		try {
			service.deleteProductByName(name);
		} catch (Exception e) {
			return new ResponseEntity<>("No Products with the name found", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	}
	
}
