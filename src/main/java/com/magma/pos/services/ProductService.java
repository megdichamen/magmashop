package com.magma.pos.services;

import com.magma.pos.dao.ProductDAO;
import com.magma.pos.dao.impl.ProductDAOImpl;
import com.magma.pos.entities.Product;

import java.util.List;

public class ProductService {

    private final ProductDAO productDAO;

    public ProductService() {
        productDAO = new ProductDAOImpl();
    }

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    public Product getProductById(int id) {
        return productDAO.findById(id);
    }

    public boolean addProduct(Product product) {
        if (product == null) {
            return false;
        }

        if (product.getName() == null || product.getName().trim().isEmpty()) {
            return false;
        }

        if (product.getPrice() < 0 || product.getQuantity() < 0) {
            return false;
        }

        return productDAO.save(product);
    }

    public boolean updateProduct(Product product) {
        if (product == null) {
            return false;
        }

        if (product.getPrice() < 0 || product.getQuantity() < 0) {
            return false;
        }

        return productDAO.update(product);
    }

    public boolean deleteProduct(int id) {
        return productDAO.delete(id);
    }
}