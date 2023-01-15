package com.root.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.exception.ProductException;
import com.root.model.Product;
import com.root.model.ProductDTO;
import com.root.productDAO.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao pDao;

	@Override
	public Product registerProduct(Product p) throws ProductException {
		
		Product prod =pDao.save(p);
		
		if(prod == null) throw new ProductException("Product registration unsuccessful!");
		else return prod;
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		List<Product> prodList = pDao.findAll();
		if(prodList.isEmpty()) throw new ProductException("No products found!");
		else return prodList;
	}

	@Override
	public Product updateProdcut(Product p) throws ProductException {
		
		Product prod = pDao.findById(p.getProductId()).orElseThrow(()-> new ProductException("Invalid Product!"));
		
		Product updatedProd= pDao.save(prod);
		return updatedProd;
		
	}

	@Override
	public Product deleteProductById(Integer pid) throws ProductException {
		Product prod = pDao.findById(pid).orElseThrow(()-> new ProductException("Invalid Product!"));
		
		pDao.delete(prod);
		return prod;
	}

	@Override
	public List<Product> getsProductByCategory(String category) throws ProductException {
		List<Product> prodList = pDao.findByCategory(category);
		
		if(prodList.isEmpty()) throw new ProductException("No product found!");
		else return prodList;
	}

	@Override
	public List<ProductDTO> getProductNameQtyPrice() throws ProductException {
		List<ProductDTO> prodList = pDao.getProductNameQtyPrice();
		
		if(prodList.isEmpty()) throw new ProductException("No product found!");
		else return prodList;
	}

}
