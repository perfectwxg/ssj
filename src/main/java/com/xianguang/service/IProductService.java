package com.xianguang.service;

import com.xianguang.domian.Product;

import java.util.List;

public interface IProductService {
	void save(Product product);

	void update(Product product);

	void delete(Long id);

	Product get(Long id);

	List<Product> getAll();
}