package com.root.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.root.exception.ProductException;
import com.root.model.Product;
import com.root.model.ProductDTO;
import com.root.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService pService;
	
	@PostMapping("/products")
	public ResponseEntity<Product> saveProduct(@RequestBody Product prod) throws ProductException{
		Product savedProd = pService.registerProduct(prod);
		
		return new ResponseEntity<Product>(savedProd,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProduct() throws ProductException{
		List<Product> prodList = pService.getAllProducts();
		
		return new ResponseEntity<List<Product>>(prodList,HttpStatus.OK);
	}
	
	@PutMapping("/products")
	public ResponseEntity<Product> updateProduct(@RequestBody Product prod) throws ProductException{
		Product updatedProd = pService.updateProdcut(prod);
		
		return new ResponseEntity<Product>(updatedProd,HttpStatus.OK);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product> saveProduct(@PathVariable Integer id) throws ProductException{
		Product deletedProd = pService.deleteProductById(id);
		
		return new ResponseEntity<Product>(deletedProd,HttpStatus.OK);
	}
	
	@GetMapping("/getProducts/{category}")
	public ResponseEntity<List<Product>> getAllProduct(@PathVariable String category) throws ProductException{
		List<Product> prodList = pService.getsProductByCategory(category);
		
		return new ResponseEntity<List<Product>>(prodList,HttpStatus.OK);
	}
	
	@GetMapping("/getProducts")
	public ResponseEntity<List<ProductDTO>> getProductNameQtyPrice() throws ProductException{
		List<ProductDTO> prodList = pService.getProductNameQtyPrice();
		
		return new ResponseEntity<List<ProductDTO>>(prodList,HttpStatus.OK);
	}

}
