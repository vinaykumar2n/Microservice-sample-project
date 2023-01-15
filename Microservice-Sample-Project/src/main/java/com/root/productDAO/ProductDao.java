package com.root.productDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.root.model.Product;
import com.root.model.ProductDTO;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{
	
	public List<Product> findByCategory(String category);
	
	@Query("select new com.root.model.ProductDTO(p.productName ,p.quantity, p.price) from Product p")
	public List<ProductDTO> getProductNameQtyPrice();
}
