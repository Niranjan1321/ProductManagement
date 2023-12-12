package com.postgreSQL.ProductManagement.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.postgreSQL.ProductManagement.models.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

	List<Product> findByPlace(String keyword);

	List<Product> findByType(String type);

	@Query(value = "SELECT * FROM product where warranty <:year", nativeQuery = true)
	List<Product> findExpiredProducts(int year);

	@Query(value = "SELECT * FROM product where place like '%:keyword%' or type like '%:keyword%' or name like '%:keyword%'", nativeQuery = true)
	List<Product> findProductsByKeyword(String keyword);

	List<Product> findByName(String name);

}
