package com.magma.pos;

import com.magma.pos.config.DatabaseConfig;
import com.magma.pos.dao.ProductDAO;
import com.magma.pos.dao.impl.ProductDAOImpl;
import com.magma.pos.entities.Customer;
import com.magma.pos.entities.Employee;
import com.magma.pos.entities.Product;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAOImpl();

        System.out.println("=== PRODUITS ===");

        for (Product product : productDAO.findAll()) {

            System.out.println(
                    product.getId() + " - " +
                            product.getName() + " - " +
                            product.getPrice() + " DT - " +
                            product.getQuantity()
            );
        }
    }
}
