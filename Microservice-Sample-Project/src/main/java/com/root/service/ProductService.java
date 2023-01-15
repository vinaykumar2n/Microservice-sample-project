package com.root.service;

import java.util.List;

import com.root.exception.ProductException;
import com.root.model.Product;
import com.root.model.ProductDTO;

public interface ProductService {
	
	public Product registerProduct(Product p)throws ProductException;
	
	public List<Product> getAllProducts()throws ProductException;
	
	public Product updateProdcut(Product p)throws ProductException;
	
	public Product deleteProductById(Integer pid)throws ProductException;
	
	public List<Product> getsProductByCategory(String category)throws ProductException;
	
	public List<ProductDTO> getProductNameQtyPrice() throws ProductException;
}
