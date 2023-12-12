package com.postgreSQL.ProductManagement.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgreSQL.ProductManagement.Dao.ProductDao;
import com.postgreSQL.ProductManagement.models.Product;

@Service
public class ProductService {

	@Autowired
	ProductDao dao;

	public void addProducts(Product p) {
		dao.save(p);
	}

	public List<Product> getAllProducts() throws SQLException {
		return dao.findAll();
	}

	public void deleteProduct(Integer id) {
		dao.deleteById(id);
	}

	public List<Product> getProductsByPlace(String keyword) {
		// TODO Auto-generated method stub
		return dao.findByPlace(keyword);
	}

	public List<Product> getExpiredProducts(int year) {
		// TODO Auto-generated method stub
		return dao.findExpiredProducts(year);
	}

	public List<Product> getProductsByType(String type) {
		// TODO Auto-generated method stub
		return dao.findByType(type);
	}

	public List<Product> getProductsByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return dao.findProductsByKeyword(keyword);
	}

	public Product updateProductsPlace(int id, String newPlace) {
		// TODO Auto-generated method stub
		Optional<Product> product = dao.findById(id);
		product.get().setPlace(newPlace);
		Product updateProduct = new Product(product.get().getId(), product.get().getName(), product.get().getPlace(),
				product.get().getType(), product.get().getWarranty());
		dao.save(updateProduct);
		return updateProduct;
	}

	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		Product product = dao.findById(id).get();
		return product;
	}

	public void deleteProductByName(String name) {
		// TODO Auto-generated method stub
		List<Product> products = dao.findByName(name);
		dao.deleteAll(products);
	}

	
}
