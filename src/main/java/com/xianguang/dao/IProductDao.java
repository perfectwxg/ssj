package com.xianguang.dao;

import com.xianguang.domian.Product;

import java.util.List;

public interface IProductDao {

    void save(Product product);

    void update(Product product);

    void delete(Long id);

    Product get(Long id);

    List<Product> getAll();
}