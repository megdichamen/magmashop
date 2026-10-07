package com.magma.pos.dao;

import com.magma.pos.entities.Product;

import java.util.List;

public interface ProductDAO {

    Product findById(int id);

    List<Product> findAll();

    boolean save(Product product);

    boolean update(Product product);

    boolean delete(int id);
}